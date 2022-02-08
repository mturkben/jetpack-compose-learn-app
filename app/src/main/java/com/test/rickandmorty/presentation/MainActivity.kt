package com.test.rickandmorty.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.*
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.test.rickandmorty.presentation.constant.BottomBarScreen
import com.test.rickandmorty.presentation.constant.StatusBarColors
import com.test.rickandmorty.presentation.theme.AppTheme
import com.test.rickandmorty.presentation.ui.character_detail.CharacterDetailScreen
import com.test.rickandmorty.presentation.ui.characters.CharacterScreen
import com.test.rickandmorty.presentation.ui.episodes.EpisodeScreen
import com.test.rickandmorty.presentation.ui.locations.LocationScreen
import com.test.rickandmorty.presentation.ui.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @Inject
    lateinit var application: BaseApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            AppTheme(
                darkTheme = application.darkMode.value,
                statusBarColors = StatusBarColors()
            ) {
                navController = rememberNavController()
                RootNavigation(navController = navController)
            }
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun RootNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "Splash", route = "root") {
        splashNavGraph(navController = navController)
        appNavGraph(navController = navController)
    }
}

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
fun NavGraphBuilder.splashNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = "loading",
        route = "Splash"
    ) {
        composable("loading") {
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
        startDestination = "BottomNav",
        route = "App"
    ) {
        composable(route = "BottomNav") {
            BottomNavigation()
        }
    }
}

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

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
fun NavGraphBuilder.characterNav(
    navController: NavHostController
) {
    navigation(
        startDestination = "CharacterList",
        route = BottomBarScreen.Characters.route
    ) {
        composable(route = "CharacterList") {
            CharacterScreen(navController = navController)
        }
        composable("CharacterDetailScreen", arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = "null"
            }
        )) {
            val characterName = it.arguments?.getString("name")
            CharacterDetailScreen(navController = navController, characterName = characterName)
        }
    }
}
