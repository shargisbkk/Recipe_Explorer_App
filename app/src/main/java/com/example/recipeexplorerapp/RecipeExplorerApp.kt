package com.example.recipeexplorerapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun RecipeExplorerApp(viewModel: RecipeViewModel = viewModel()) {
    val configuration = LocalConfiguration.current
    val isTablet = configuration.screenWidthDp >= 600

    if (isTablet) {
        TabletLayout(viewModel)
    } else {
        PhoneLayout(viewModel)
    }
}

@Composable
fun PhoneLayout(viewModel: RecipeViewModel) {
    val navController = rememberNavController()
    val recipes by viewModel.recipes.collectAsState()

    NavHost(navController = navController, startDestination = "recipeList") {
        composable("recipeList") {
            RecipeListScreen(
                recipes = recipes,
                onRecipeClick = { id ->
                    viewModel.selectRecipe(id)
                    navController.navigate("recipeDetail/$id")
                }
            )
        }
        composable(
            route = "recipeDetail/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getInt("recipeId")
            val recipe = recipes.find { it.id == recipeId }
            RecipeDetailScreen(
                recipe = recipe,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun TabletLayout(viewModel: RecipeViewModel) {
    val recipes by viewModel.recipes.collectAsState()
    val selectedRecipeId by viewModel.selectedRecipeId.collectAsState()
    val selectedRecipe = recipes.find { it.id == selectedRecipeId }

    Row(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            RecipeListScreen(
                recipes = recipes,
                onRecipeClick = { id -> viewModel.selectRecipe(id) }
            )
        }
        VerticalDivider(modifier = Modifier.fillMaxHeight().width(1.dp))
        Box(modifier = Modifier.weight(1.5f)) {
            RecipeDetailScreen(recipe = selectedRecipe)
        }
    }
}

@Composable
fun VerticalDivider(modifier: Modifier = Modifier) {
    androidx.compose.material3.VerticalDivider(modifier = modifier)
}
