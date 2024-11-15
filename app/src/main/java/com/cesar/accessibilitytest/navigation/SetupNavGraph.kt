package com.cesar.accessibilitytest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cesar.accessibilitytest.LoginScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    val startDestination =  Screen.Login.route
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Screen.Login.route,
        ) {
            LoginScreen {
                navController.navigate(Screen.Menu.route)
                true
            }
        }

        composable(
            route = Screen.Menu.route,
        ) {
            Menu()
        }
    }


}