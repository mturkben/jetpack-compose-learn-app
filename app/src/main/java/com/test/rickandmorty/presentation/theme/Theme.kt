package com.test.rickandmorty.presentation.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.test.rickandmorty.presentation.constant.StatusBarColors
import kotlinx.coroutines.ExperimentalCoroutinesApi

private val LightThemeColors = lightColors(
    primary = Blue600,
    primaryVariant = Blue400,
    onPrimary = Black2,
    secondary = Color.White,
    secondaryVariant = Teal300,
    onSecondary = Color.Black,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Grey1,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
)

private val DarkThemeColors = darkColors(
    primary = Blue700,
    primaryVariant = Color.White,
    onPrimary = Color.White,
    secondary = Black1,
    onSecondary = Color.White,
    error = RedErrorLight,
    background = Color.Black,
    onBackground = Color.White,
    surface = Black1,
    onSurface = Color.White,
)


@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun AppTheme(
    darkTheme: Boolean,
    statusBarColors: StatusBarColors?,
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    val focusManager = LocalFocusManager.current

    LaunchedEffect(true) {
        systemUiController.setStatusBarColor(
            color = statusBarColors?.color ?: Color.White,
            darkIcons = statusBarColors?.darkIcons ?: true
        )
    }

    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = NormalType,
        shapes = Shapes,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            focusManager.clearFocus()
                        },
                        onTap = {
                            focusManager.clearFocus()
                        }
                    )
                }
        ) {
            content()
        }
    }
}