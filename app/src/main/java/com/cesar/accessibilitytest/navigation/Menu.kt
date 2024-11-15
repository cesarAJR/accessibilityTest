package com.cesar.accessibilitytest.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.cesar.accessibilitytest.BottomNavigationItem
import com.cesar.accessibilitytest.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun Menu(modifier: Modifier = Modifier) {

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val items = listOf(
        BottomNavigationItem(
            title = "Detalle",
            icon = R.drawable.ic_tab_home,
            route = ScreenHome.Detail.route
        ),
        BottomNavigationItem(
            title = "Mensajes",
            icon = R.drawable.ic_tab_message,
            route = ScreenHome.Messages.route
        ),
        BottomNavigationItem(
            title = "Articulo",
            icon = R.drawable.ic_tab_settings,
            route = ScreenHome.Settings.route
        )
    )

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier.height(75.dp),
                containerColor = Color(android.graphics.Color.parseColor("#DCE3E9")),
            ) {
                items.forEachIndexed { index,item ->

                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor =Color(android.graphics.Color.parseColor("#DCE3E9"))
                        ),
                        selected = selectedItemIndex ==  index,
                        onClick  = {
                            if (selectedItemIndex !=  index){
                                selectedItemIndex = index
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                }
                            }
                        },
                        alwaysShowLabel = selectedItemIndex ==  index,
                        label = {
                            if (selectedItemIndex ==  index)
                                Text(
                                    text = item.title,
                                    color =  Color(android.graphics.Color.parseColor("#00668B")),
                                    fontSize = 14.sp
                                )
                        },
                        icon={
                            Icon(
                                imageVector =  ImageVector.vectorResource(item.icon),
                                tint = if (selectedItemIndex ==  index)
                                    Color(android.graphics.Color.parseColor("#00668B"))
                                else
                                    Color(android.graphics.Color.parseColor("#00668B"))
                                ,
                                contentDescription = item.title,
                            )
                        }
                    )
                }

            }
        }
    ){paddings->
        SetupNavGraphHome(navController = navController, paddings = paddings)
    }

}