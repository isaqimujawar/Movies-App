package com.maddy.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.maddy.movieapp.screens.details.DetailsScreen
import com.maddy.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(route = MovieScreens.HomeScreen.name) {
            // here we pass where this composable should lead us to.
            HomeScreen(navController = navController)
        }

        // www.google.com/details-screen/id=34  Here, route link is mimicking the web link address.
        composable(
            route = MovieScreens.DetailsScreen.name + "/{movieId}",
            arguments = listOf(navArgument(name = "movieId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movieId")
            )
        }
    }
}