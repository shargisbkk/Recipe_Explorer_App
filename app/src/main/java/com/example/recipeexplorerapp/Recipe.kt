package com.example.recipeexplorerapp

data class Recipe(
    val id: Int,
    val title: String,
    val description: String,
    val details: String
)

val sampleRecipes = listOf(
    Recipe(1, "Spaghetti CarbonAraAra", "A classic Italian pasta dish with a Japanese twist.", "Ingredients: Spaghetti, Eggs, Pecorino Romano, Guanciale, Black Pepper. \n\nMethod: Boil pasta. Fry guanciale. Mix eggs and cheese. Combine all with pasta and some pasta water. Serve with a side of Dommy Mommy."),
    Recipe(2, "Chicken Tikka Masala", "Indian curry. Best served buffet style.", "Ingredients: Chicken, Yogurt, Lemon juice, Ginger, Garlic, Garam Masala, Turmeric, Cumin, Tomato puree, Cream. \n\nMethod: Marinate and grill chicken. Sauté aromatics, add spices and tomato. Stir in cream and chicken."),
    Recipe(3, "Guacamelee", "Super smashed avocado dip.", "Ingredients: Avocados, Lime juice, Onion, Cilantro, Tomatoes, Jalapeño, Salt. \n\nMethod: Falcon punch avocados. Mix in Luigi chopped ingredients. Season with salt of your opponents and lime juice."),
    Recipe(4, "Hobbit Stew", "Hearty and comforting winter meal.", "Ingredients: Hobbit meat, Potatoes, Carrots, Onions, Beef broth, Red wine, Thyme, Rosemary. \n\nMethod: Boil 'em. Mash 'em. Stick 'em in a pot. Sauté vegetables. Deglaze with wine. Add broth and herbs. Simmer until tender."),
    Recipe(5, "Bacon Pancakes", "Makin Bacon Pancakes.", "Ingredients: Bacon, Flour, Milk, Eggs, Butter, Sugar, Baking powder, Salt. \n\nMethod: Whisk dry ingredients. Add wet ingredients. Mix until combined. Cook on a hot griddle. Pan fry bacon till crispy. Top pancakes with freshly fried bacon.")
)
