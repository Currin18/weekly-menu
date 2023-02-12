package com.jesusmoreira.weeklymenu.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.R
import com.jesusmoreira.weeklymenu.ui.navigation.Router

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        NavigationItem(
            icon = Icons.Filled.LocalDining,
            label = stringResource(id = R.string.menu),
            route = Router.MenuScreen.route,
            navController = navController,
            currentDestination = currentDestination
        )

        NavigationItem(
            icon = Icons.Filled.MenuBook,
            label = stringResource(id = R.string.cookbook),
            route = Router.CookbookScreen.route,
            navController = navController,
            currentDestination = currentDestination
        )
    }
}

@Composable
fun RowScope.NavigationItem(
    icon: ImageVector,
    label: String,
    route: String,
    navController: NavController,
    currentDestination: NavDestination?
) {
    NavigationBarItem(
        icon = { Icon(icon, contentDescription = label) },
        label = { Text(text = label) },
        selected = currentDestination?.hierarchy?.any { it.route == route } == true,
        onClick = {
            navController.navigate(route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        }
    )
}

@Composable
@Preview
fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}
