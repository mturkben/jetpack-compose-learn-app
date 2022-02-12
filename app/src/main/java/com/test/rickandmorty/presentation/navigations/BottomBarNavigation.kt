package com.test.rickandmorty.presentation.navigations

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.test.rickandmorty.presentation.constant.BottomBarScreen
import com.test.rickandmorty.presentation.ui.episode_list.EpisodeScreen
import com.test.rickandmorty.presentation.ui.location_list.LocationScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun BottomNavigation() {
    val navController: NavHostController = rememberNavController()
    Scaffold(
        topBar = {},
        bottomBar = { BottomBar(navController = navController) }
    ) {
        BottomBarGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {

    val screens = listOf(
        BottomBarScreen.Characters,
        BottomBarScreen.Locations,
        BottomBarScreen.Episodes
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "NavIcon")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun BottomBarGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Characters.route) {
        characterNav(navController = navController)
        composable(route = BottomBarScreen.Locations.route) {
            LocationScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Episodes.route) {
            EpisodeScreen(navController = navController)
        }
    }
}
