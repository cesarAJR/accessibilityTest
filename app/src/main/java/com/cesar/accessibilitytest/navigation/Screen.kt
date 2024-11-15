package com.cesar.accessibilitytest.navigation

sealed class Screen(val route:String) {
    object Login: Screen("login_screen")
    object Menu: Screen("menu_screen")
}