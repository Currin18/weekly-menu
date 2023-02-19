package com.jesusmoreira.weeklymenu.ui.recipedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.domain.model.Service
import com.jesusmoreira.weeklymenu.ui.common.DefaultImage
import com.jesusmoreira.weeklymenu.ui.common.TimeWidget
import com.jesusmoreira.weeklymenu.ui.common.TopActionBar

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
            ) {
                RecipeOverview(
                    name = recipe.name,
                    services = recipe.services,
                    description = recipe.description,
                    time = recipe.time,
                )
            }
        }
    )
}

@Composable
fun RecipeOverview(
    name: String,
    services: Set<Service>,
    description: String,
    time: Int,
) {
    val horizontalPadding = 16.dp
    val verticalPadding = 8.dp

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box {
            DefaultImage(aspectRatio = 2f / 1)
            ServiceList(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp),
                services = services
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = verticalPadding),
            style = MaterialTheme.typography.titleLarge,
            text = name
        )
        RecipeOverviewExtra(
            modifier = Modifier.padding(horizontal = horizontalPadding, vertical = verticalPadding),
            time = time
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = verticalPadding),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify,
            text = description
        )
    }
}

@Composable
fun ServiceList(modifier: Modifier = Modifier, services: Set<Service> = setOf()) {
    if (services.isNotEmpty()) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.End
        ) {
            services.forEach {
                Text(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp))
                        .background(MaterialTheme.colorScheme.tertiaryContainer)
                        .padding(8.dp),
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    style = MaterialTheme.typography.bodyLarge,
                    text = it.toString().capitalize(Locale.current)
                )
            }
        }
    }
}

@Composable
fun RecipeOverviewExtra(modifier: Modifier = Modifier, time: Int) {
    Row(modifier = modifier) {
        TimeWidget(time = time)
    }
}

/**
 * Previews
 */

@Composable
@Preview(showBackground = true)
fun RecipeOverviewPreview() {
    RecipeOverview(
        name = "Spicy Hoisin Pork",
        services = setOf(Service.LUNCH, Service.DINNER),
        description = "Whip out your wok and get sticky pork, crisp greens and fluffy " +
                "rice on the table in no time! To serve garnish with a sprinkle of fresh " +
                "chilli. Simple, spicy and full of garlicky goodness!",
        35,
    )
}

@Composable
@Preview
fun RecipeDetailScreenPreview() {
    RecipeDetailScreen(rememberNavController(), recipeId = 0, RecipeDetailViewModel())
}