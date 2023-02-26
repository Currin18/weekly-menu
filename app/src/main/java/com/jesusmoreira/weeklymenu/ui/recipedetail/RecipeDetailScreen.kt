package com.jesusmoreira.weeklymenu.ui.recipedetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.R
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.ui.common.TopActionBar
import com.jesusmoreira.weeklymenu.ui.navigation.Router

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(
    navController: NavController,
    recipeId: Int,
    viewModel: RecipeDetailViewModel
) {
    val recipe by viewModel.recipe.observeAsState(Recipe())
    
    Scaffold(
        topBar = { TopActionBar(
            title = recipe.name,
            showBackButton = true,
            onBackButton = { navController.popBackStack() },
            actions = {
                IconButton(onClick = {
                    navController.navigate(
                        Router.RecipeEditScreen.route
                            .replace("{recipeId}", "$recipeId")
                    )
                }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit icon")
                }
                IconButton(onClick = {
                    viewModel.deleteRecipe()
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete icon")
                }
            }
        ) },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    RecipeOverview(
                        name = recipe.name,
                        description = recipe.description,
                        time = recipe.time,
                        difficulty = recipe.difficulty,
                        services = recipe.services,
                        tags = recipe.tags,
                    )
                }
                item {
                    RecipeIngredients(ingredients = recipe.ingredients)
                }
                recipe.directions.forEachIndexed { index, direction ->
                    item {
                        RecipeDirection(step = index + 1, direction = direction)
                    }
                }
            }
        }
    )
}

@Composable
fun RecipeDirection(step: Int, direction: String) {
    val horizontalPadding = 16.dp
    val verticalPadding = 8.dp

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = verticalPadding),
            style = MaterialTheme.typography.titleMedium,
            text = "${stringResource(id = R.string.step)} $step"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = verticalPadding),
            style = MaterialTheme.typography.bodyLarge,
            text = direction
        )
    }
}

/**
 * Previews
 */

@Composable
@Preview
fun RecipeDetailScreenPreview() {
    RecipeDetailScreen(rememberNavController(), recipeId = 0, RecipeDetailViewModel())
}