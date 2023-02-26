package com.jesusmoreira.weeklymenu.core.util

import com.jesusmoreira.weeklymenu.domain.model.Difficulty
import com.jesusmoreira.weeklymenu.domain.model.Ingredient
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.domain.model.Service
import com.jesusmoreira.weeklymenu.domain.model.Unit

object PopulateUtil {

    private fun defaultRecipe() = Recipe(
        name = "Chimichurri Chicken",
        description = "Chicken tenders for a crowd cook up quickly in the oven, with fresh, herby flavor from chimichurri. Make the chimichurri sauce the day before, if you like, and simply refrigerate in a sealed container until you are ready to bake. We like this with Mexican rice, black beans, and a simple green salad.",
        isFavorite = false,
        time = 40,
        difficulty = Difficulty.EASY,
        services = setOf(Service.LUNCH, Service.DINNER),
        tags = listOf("chicken"),
        ingredients = listOf(
            Ingredient("packed fresh parsley leaves", 1, Unit.UNITS),
            Ingredient("tablespoons fresh oregano leaves", 2, Unit.UNITS),
        ),
        directions = listOf(
            "Preheat the oven to 375 degrees F (190 degrees C). Line a 12x18-inch sheet pan with parchment or aluminum foil; set aside.",
            "Combine parsley, oregano, garlic, green onions, and jalapeño in the bowl of a food processor. Pulse just a few times to break up the parsley and combine the ingredients. Place processed vegetables in a small bowl; stir in vinegar, lemon juice, and olive oil. Season with salt and black pepper.",
            "Place chicken tenders in a single layer on the prepared pan. Lightly season with salt and pepper; sprinkle smoked paprika evenly over the tenders. Spoon half of the chimichurri evenly over the tenders. Reserve remaining half of chimichurri, covered, in the refrigerator to use later.",
            "Bake in the preheated oven until chicken is no longer pink in the center and the juices run clear, about 18 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C).",
            "Serve tenders with reserved chimichurri sauce.",
        )
    )

    fun populateRecipes(numOfRecipes: Int = 5): List<Recipe> {
        val list: MutableList<Recipe> = mutableListOf()
        for (i in 1..numOfRecipes) {
            list.add(defaultRecipe())
        }
        return list
    }
}