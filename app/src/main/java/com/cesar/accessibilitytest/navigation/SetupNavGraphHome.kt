package com.cesar.accessibilitytest.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cesar.accessibilitytest.MenuScreen
import com.cesar.accessibilitytest.DetailScreen
import com.cesar.accessibilitytest.NotificationsScreen


@Composable
fun SetupNavGraphHome(navController: NavHostController, paddings: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination =  ScreenHome.Detail.route
    ){
        composable(route = ScreenHome.Detail.route){
            DetailScreen()
        }
        composable(route = ScreenHome.Messages .route){
            NotificationsScreen()
        }
        composable(route = ScreenHome.Settings.route){
            MenuScreen(paddings)
        }
    }

}