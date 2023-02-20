package com.jesusmoreira.weeklymenu.ui.recipedetail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.ui.common.TopActionBar
import com.jesusmoreira.weeklymenu.ui.recipe.RecipeIngredients
import com.jesusmoreira.weeklymenu.ui.recipe.RecipeOverview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(navController: NavController, recipeId: Int, viewModel: RecipeDetailViewModel) {
    val recipe by viewModel.recipe.observeAsState(Recipe())

    viewModel.setRecipeId(recipeId)
    
    Scaffold(
        topBar = { TopActionBar(
            title = recipe.name,
            showBackButton = true,
            onBackButton = { navController.popBackStack() }
        ) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                RecipeOverview(
                    name = recipe.name,
                    description = recipe.description,
                    time = recipe.time,
                    difficulty = recipe.difficulty,
                    services = recipe.services,
                    tags = recipe.tags,
                )
                RecipeIngredients(ingredients = recipe.ingredients)
            }
        }
    )
}

/**
 * Previews
 */

@Composable
@Preview
fun RecipeDetailScreenPreview() {
    RecipeDetailScreen(rememberNavController(), recipeId = 0, RecipeDetailViewModel())
}