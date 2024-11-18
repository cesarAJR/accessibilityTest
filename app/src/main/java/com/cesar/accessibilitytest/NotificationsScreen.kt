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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun NotificationsScreen(
) {

    val list = mutableListOf("Juan Carlos","Pedro Lopez","Alex","Patricio")

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
                    Card(modifier =
                    Modifier
                        .fillMaxWidth()
                        .semantics(mergeDescendants = true) {
                            customActions = listOf(
                                CustomAccessibilityAction("", { true })
                            )
                        },

                        colors = CardDefaults.cardColors(
                            containerColor = Color(android.graphics.Color.parseColor("#DCE3E9")),
                        )
                    ) {
                        ConstraintLayout(
                            Modifier
                                .padding(10.dp)
                                .fillMaxWidth()) {
                            val (iv,spacer1,column,icoClose) = createRefs()
                            Image(modifier = Modifier.constrainAs(iv){
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                            },
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(Color.Black)
                            )
                            Spacer(modifier = Modifier
                                .width(5.dp)
                                .constrainAs(spacer1) {
                                    top.linkTo(parent.top)
                                    start.linkTo(iv.end)
                                    width = Dimension.fillToConstraints
                                })
                            Column(modifier = Modifier.constrainAs(column){
                                top.linkTo(parent.top)
                                start.linkTo(spacer1.end)
                            }) {
                                Text(it, style = TextStyle(fontSize = 16.sp, color = Color.Black))
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Peruano",style = TextStyle(fontSize = 16.sp, color = Color.Black))
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Lima",style = TextStyle(fontSize = 16.sp, color = Color.Black))
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("32 años",style = TextStyle(fontSize = 16.sp, color = Color.Black))
                            }
                            IconButton(
                                modifier = Modifier.constrainAs(icoClose){
                                    top.linkTo(parent.top)
                                    end.linkTo(parent.end)
                                },
                                onClick = { true }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "cerrar",
                                    tint = Color.Black
                                )
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