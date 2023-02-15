package com.jesusmoreira.weeklymenu.ui.cookbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.R
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.ui.components.BottomNavigationBar
import com.jesusmoreira.weeklymenu.ui.components.TopActionBar
import com.jesusmoreira.weeklymenu.ui.navigation.Router

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CookbookScreen(navController: NavHostController, viewModel: CookbookViewModel) {
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val recipes: List<Recipe> by viewModel.recipes.observeAsState(initial = listOf())

    viewModel.loadRecipes()

    Scaffold(
        topBar = { TopActionBar(stringResource(id = R.string.cookbook), false) },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (isLoading) CircularProgressIndicator(progress = 0.5f)
                else Cookbook(recipes)
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Router.RecipeNewScreen.route) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add recipe")
            }
        },
        bottomBar = { BottomNavigationBar(navController = navController) }
    )
}

@Composable
@Preview(showBackground = true)
fun CookbookScreenPreview() {
    CookbookScreen(rememberNavController(), CookbookViewModel(null))
}
