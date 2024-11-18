package com.cesar.accessibilitytest

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DetailScreen(
) {
    var checked by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var value1 by remember { mutableStateOf("") }
    var valueType by remember { mutableStateOf("") }

    val list = mutableListOf("DNI","Carnet extranjeria","Pasaporte","Otro")
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
        ){
            Text(
                "Datos Personales",
                modifier = Modifier.padding(16.dp).semantics { heading() },
                style = TextStyle(fontSize = 20.sp),
                fontWeight = FontWeight.Bold
            )
            Row(
                Modifier
                    .toggleable(
                        value = checked,
                        role = Role.Checkbox,
                        onValueChange = { checked = !checked }
                    )
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "¿Eres Mayor de edad?",
                    Modifier.weight(1f),
                    style = TextStyle(fontSize = 16.sp)
                )
                Checkbox(checked = checked, onCheckedChange = null)
            }

            Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(

                    "Lugar de Nacimiento",
                    style = TextStyle(fontSize = 16.sp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    modifier =
                    Modifier.semantics {
                        this.contentDescription = "Ingresar Lugar de Nacimiento"
                    },
                    value = value1,
                    textStyle = TextStyle(),
                    onValueChange = {
                        value1 = it
                    }
                )
            }

            Text(
                "Datos Opcionales",
                modifier = Modifier.padding(16.dp).semantics { heading() },
                style = TextStyle(fontSize = 20.sp),
                fontWeight = FontWeight.Bold
            )

            Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "Tipo de Documento",
                    style = TextStyle(fontSize = 16.sp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    Box(modifier = Modifier.size(width = 250.dp, height = 180.dp)) {
                        LazyColumn {
                            items(list) { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        valueType = item
                                        expanded = false
                                    },
                                )
                            }
                        }
                    }
                }
                TextField(
                    modifier =
                    Modifier.semantics {
                        this.contentDescription = "Ingresar Tipo de Documento"
                    }.clickable {
                        expanded = !expanded
                    },
                    value = valueType,
                    textStyle = TextStyle(),
                    onValueChange = {
                        valueType = it
                    },
                    readOnly = true
                )
            }

        }
    }


}

@Preview(name="Apps",showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen()
}