package com.test.rickandmorty.presentation.ui.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.skydoves.landscapist.glide.GlideImage
import com.test.rickandmorty.R
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(navController) {
        delay(1500)
        navController.navigate("App") {
            popUpTo(navController.graph.findStartDestination().id) {
                inclusive = true
            }
        }
    }

    GlideImage(
        imageModel = R.drawable.splash,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}