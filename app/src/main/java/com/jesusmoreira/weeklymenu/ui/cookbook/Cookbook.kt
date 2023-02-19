package com.jesusmoreira.weeklymenu.ui.cookbook

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.ui.common.RecipeCard

@Composable
fun Cookbook(recipes: List<Recipe>, onClickCard: (Int) -> Unit = {}) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(24.dp)
    ) {
        if (recipes.isNotEmpty()) {
            items(
                items = recipes,
                key = { it.id ?: 0 }
            ) { item ->
                RecipeCard(recipe = item, onClick = { onClickCard(it.id!!) })
            }
        }
    }
}

@Composable
fun RecipeRow(recipe: Recipe) {
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Text(text = recipe.name)
        }
        Divider()
    }
}

/**
 * Previews
 */

@Composable
@Preview(showBackground = true)
fun RecipeRowPreview() {
    RecipeRow(Recipe(
        id = 1,
        name ="Huevos con patatas",
        ingredients = emptyList(),
        description = "description")
    )
}

@Composable
@Preview(showBackground = true)
fun CookbookPreview() {
    Cookbook(listOf(
        Recipe(id = 1, name = "Huevos con patatas"),
        Recipe(id = 2, name = "Huevos con patatas 2")
    ))
}