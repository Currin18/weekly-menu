package com.jesusmoreira.weeklymenu.ui.navigation

sealed class Router(val route: String) {
    object MenuScreen: Router(Routes.MENU_SCREEN)
    object CookbookScreen: Router(Routes.COOKBOOK_SCREEN)
    object RecipeNewScreen: Router(Routes.RECIPE_NEW_SCREEN)
    object RecipeEditScreen: Router(Routes.RECIPE_EDIT_SCREEN)
}
