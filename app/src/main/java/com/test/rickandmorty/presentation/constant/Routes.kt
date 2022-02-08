package com.test.rickandmorty.presentation.constant

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.LiveTv
import androidx.compose.material.icons.rounded.People
import androidx.compose.ui.graphics.vector.ImageVector


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