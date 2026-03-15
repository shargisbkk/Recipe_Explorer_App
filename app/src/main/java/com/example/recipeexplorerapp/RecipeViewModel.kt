package com.example.recipeexplorerapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecipeViewModel : ViewModel() {
    private val _recipes = MutableStateFlow(sampleRecipes)
    val recipes: StateFlow<List<Recipe>> = _recipes.asStateFlow()

    private val _selectedRecipeId = MutableStateFlow<Int?>(null)
    val selectedRecipeId: StateFlow<Int?> = _selectedRecipeId.asStateFlow()

    fun selectRecipe(id: Int) {
        _selectedRecipeId.value = id
    }
}
