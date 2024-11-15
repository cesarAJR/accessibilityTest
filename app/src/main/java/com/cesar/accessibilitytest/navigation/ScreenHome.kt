package com.cesar.accessibilitytest.navigation

sealed class ScreenHome(val route:String){
    object Detail : ScreenHome("detail_screen")
    object Messages : ScreenHome("messages_screen")
    object Settings : ScreenHome("settings_screen")


}