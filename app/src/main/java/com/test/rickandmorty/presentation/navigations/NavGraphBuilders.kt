package com.test.rickandmorty.presentation.navigations

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.test.rickandmorty.presentation.constant.*
import com.test.rickandmorty.presentation.ui.character_detail.CharacterDetailScreen
import com.test.rickandmorty.presentation.ui.character_list.CharacterScreen
import com.test.rickandmorty.presentation.ui.location_list.LocationScreen
import com.test.rickandmorty.presentation.ui.splash.SplashScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
fun NavGraphBuilder.splashNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = SplashRoutes.Loading.route,
        route = SplashRoutes.Splash.route
    ) {
        composable(route = SplashRoutes.Loading.route) {
            SplashScreen(navController = navController)
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
fun NavGraphBuilder.appNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = BottomBar,
        route = App
    ) {
        composable(route = BottomBar) {
            BottomNavigation()
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
fun NavGraphBuilder.characterNav(
    navController: NavHostController
) {
    navigation(
        startDestination = AppRoutes.Characters.route,
        route = BottomBarScreen.Characters.route
    ) {
        composable(route = AppRoutes.Characters.route) {
            CharacterScreen(navController = navController)
        }
        composable(
            route = AppRoutes.CharacterDetail.route,
            arguments = AppRoutes.CharacterDetail.arguments
        ) {
            val characterId = it.arguments?.getString("characterId") ?: "-1"
            CharacterDetailScreen(navController = navController, characterId = characterId)
        }
    }
}


@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
fun NavGraphBuilder.locationNav(
    navController: NavHostController
) {
    navigation(startDestination = AppRoutes.Location.route, BottomBarScreen.Locations.route) {
        composable(route = AppRoutes.Location.route) {
            LocationScreen(navController = navController)
        }
    }
}


@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
fun NavGraphBuilder.episodeNav(
    navController: NavHostController
) {
    navigation(startDestination = AppRoutes.Episodes.route, BottomBarScreen.Episodes.route) {
        composable(route = AppRoutes.Episodes.route) {
            LocationScreen(navController = navController)
        }
    }
}
