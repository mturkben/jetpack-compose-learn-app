package com.test.rickandmorty.presentation.ui.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.skydoves.landscapist.glide.GlideImage
import com.test.rickandmorty.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashScreenViewModel = hiltViewModel()
) {

    GlideImage(
        imageModel = R.drawable.splash,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}