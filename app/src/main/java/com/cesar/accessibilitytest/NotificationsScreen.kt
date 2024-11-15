package com.cesar.accessibilitytest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotificationsScreen(
) {

    val list = mutableListOf("Juan Carlos","Pedro Lopez","Alex","patricio")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)
        ) {
            LazyColumn {
                items(list){
                    Box(modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(Color(android.graphics.Color.parseColor("#4a65a0")))
                        .semantics(mergeDescendants = true) {}
                    ) {
                        Row(modifier = Modifier.padding(10.dp)) {
                            Image(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(Color.White)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Column {
                                Text(it, style = TextStyle(fontSize = 16.sp, color = Color.White))
                                Text("Peruano",style = TextStyle(fontSize = 16.sp, color = Color.White))
                                Text("Lima",style = TextStyle(fontSize = 16.sp, color = Color.White))
                                Text("32 años",style = TextStyle(fontSize = 16.sp, color = Color.White))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Preview(name="Apps",showSystemUi = true)
@Composable
fun NotificationsScreenPreview() {
    NotificationsScreen()
}