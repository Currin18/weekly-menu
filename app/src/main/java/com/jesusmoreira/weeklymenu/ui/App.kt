package com.jesusmoreira.weeklymenu.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.ui.cookbook.CookbookScreen
import com.jesusmoreira.weeklymenu.ui.cookbook.CookbookViewModel
import com.jesusmoreira.weeklymenu.ui.menu.MenuScreen
import com.jesusmoreira.weeklymenu.ui.menu.MenuViewModel
import com.jesusmoreira.weeklymenu.ui.navigation.Router
import com.jesusmoreira.weeklymenu.ui.recipeform.RecipeFormScreen
import com.jesusmoreira.weeklymenu.ui.recipeform.RecipeFormViewModel
import com.jesusmoreira.weeklymenu.ui.recipedetail.RecipeDetailScreen
import com.jesusmoreira.weeklymenu.ui.recipedetail.RecipeDetailViewModel

@Composable
fun App(
    menuViewModel: MenuViewModel,
    cookbookViewModel: CookbookViewModel,
    recipeFormViewModel: RecipeFormViewModel,
    recipeDetailViewModel: RecipeDetailViewModel,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Router.CookbookScreen.route) {
        composable(route = Router.MenuScreen.route) {
            MenuScreen(navController = navController, viewModel = menuViewModel)
        }
        composable(route = Router.CookbookScreen.route) {
            CookbookScreen(navController = navController, viewModel = cookbookViewModel)
        }
        composable(route = Router.RecipeNewScreen.route) {
            recipeFormViewModel.clear()
            RecipeFormScreen(navController = navController, viewModel = recipeFormViewModel)
        }
        composable(route = Router.RecipeEditScreen.route) { backStackEntry ->
            backStackEntry.arguments?.getString("recipeId")?.let {
                recipeFormViewModel.setRecipeId(it.toInt())
                RecipeFormScreen(navController = navController, viewModel = recipeFormViewModel)
            }
        }
        composable(route = Router.RecipeDetail.route) { backStackEntry ->
            backStackEntry.arguments?.getString("recipeId")?.let {
                recipeDetailViewModel.setRecipeId(it.toInt())
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