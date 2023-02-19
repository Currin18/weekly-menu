package com.jesusmoreira.weeklymenu.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.ui.cookbook.CookbookScreen
import com.jesusmoreira.weeklymenu.ui.cookbook.CookbookViewModel
import com.jesusmoreira.weeklymenu.ui.menu.MenuScreen
import com.jesusmoreira.weeklymenu.ui.menu.MenuViewModel
import com.jesusmoreira.weeklymenu.ui.navigation.Router
import com.jesusmoreira.weeklymenu.ui.recipe.RecipeScreen
import com.jesusmoreira.weeklymenu.ui.recipe.RecipeViewModel
import com.jesusmoreira.weeklymenu.ui.recipedetail.RecipeDetailScreen
import com.jesusmoreira.weeklymenu.ui.recipedetail.RecipeDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    menuViewModel: MenuViewModel,
    cookbookViewModel: CookbookViewModel,
    recipeViewModel: RecipeViewModel,
    recipeDetailViewModel: RecipeDetailViewModel,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Router.MenuScreen.route) {
        composable(route = Router.MenuScreen.route) {
            MenuScreen(navController = navController, viewModel = menuViewModel)
        }
        composable(route = Router.CookbookScreen.route) {
            CookbookScreen(navController = navController, viewModel = cookbookViewModel)
        }
        composable(route = Router.RecipeNewScreen.route) {
            RecipeScreen(navController = navController, recipeViewModel)
        }
        composable(route = Router.RecipeDetail.route) { backStackEntry ->
            backStackEntry.arguments?.getString("recipeId")?.let {
                RecipeDetailScreen(
                    navController = navController,
                    recipeId = it.toInt(),
                    viewModel = recipeDetailViewModel
                )
            }
        }
    }
}

//@Composable
//@Preview(
//    showSystemUi = true,
//    showBackground = true
//)
//fun AppPreview() {
//    App(menuViewModel = MenuViewModel())
//}