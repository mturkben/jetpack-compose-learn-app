package com.test.rickandmorty.presentation.constant

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.LiveTv
import androidx.compose.material.icons.rounded.People
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

const val Root = "Root"
const val App = "App"
const val BottomBar = "BottomBar"

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    object Characters : BottomBarScreen(
        route = "Characters",
        title = "Characters",
        icon = Icons.Rounded.People
    )

    object Locations : BottomBarScreen(
        route = "Locations",
        title = "Locations",
        icon = Icons.Rounded.Explore
    )

    object Episodes : BottomBarScreen(
        route = "Episodes",
        title = "Episodes",
        icon = Icons.Rounded.LiveTv
    )
}

sealed class SplashRoutes(
    var route: String
) {
    object Splash : SplashRoutes(
        route = "SplashScreen"
    )

    object Loading : SplashRoutes(
        route = "LoadingScreen"
    )
}

sealed class AppRoutes(
    var route: String,
    var arguments: List<NamedNavArgument> = listOf(),
) {

    object Characters : AppRoutes(
        route = "CharacterListScreen",
    )

    object CharacterDetail : AppRoutes(
        route = "CharacterDetailScreen/{characterId}",
        arguments = listOf(
            navArgument("characterId") {
                type = NavType.StringType
            })
    )

    object Location : AppRoutes(
        route = "LocationListScreen"
    )

    object LocationDetail : AppRoutes(
        route = "LocationDetailScreen"
    )

    object Episodes : AppRoutes(
        route = "EpisodesListScreen"
    )

    object EpisodeDetail : AppRoutes(
        route = "EpisodeDetailScreen"
    )
}