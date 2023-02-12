package com.jesusmoreira.weeklymenu.ui.navigation

sealed class Router(val route: String) {
    object MenuScreen: Router(Routes.MENU_SCREEN)
    object CookbookScreen: Router(Routes.COOKBOOK_SCREEN)
}
