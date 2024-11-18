package com.cesar.accessibilitytest.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics

@Composable
fun DialogGeneral(shouldShowDialog: MutableState<Boolean>) {
    if (shouldShowDialog.value) {
        AlertDialog(
            modifier = Modifier.semantics(mergeDescendants = true) {
                customActions = listOf(
                    CustomAccessibilityAction("", { true })
                )
            },
            onDismissRequest = {
                shouldShowDialog.value = false
            },
            title = { Text(text = "Alerta") },
            text = { Text(text = "Ingrese datos correctos") },
            confirmButton = {
                Button(
                    modifier = Modifier
                        .semantics {
                            onClick(label = "cerrar alerta", action = {
                                shouldShowDialog.value = false
                            true})
                        },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(android.graphics.Color.parseColor("#00668B"))
                    ),
                    onClick = {
                        shouldShowDialog.value = false
                    }
                ) {
                    Text(
                        text = "Ok",
                        color = Color.White
                    )
                }
            }
        )
    }
}