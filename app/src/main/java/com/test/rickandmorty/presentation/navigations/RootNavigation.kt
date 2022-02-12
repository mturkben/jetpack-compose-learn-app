package com.test.rickandmorty.presentation.navigations

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.test.rickandmorty.presentation.constant.Root
import com.test.rickandmorty.presentation.constant.SplashRoutes
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun RootNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = SplashRoutes.Splash.route,
        route = Root
    ) {
        splashNavGraph(navController = navController)
        appNavGraph(navController = navController)
    }
}
