package com.sarvesh.jetcompose_modules.RadioButtons

import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RadioButtonScreen(){
    val genderList by remember { mutableStateOf(listOf("Male","Female","Others"))}
    var genderState by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            genderList.forEach {
                Row() {
                    Text(text = it, modifier = Modifier.align(CenterVertically))
                    RadioButton(selected = genderState == it,
                        onClick = {
                            genderState = it
                        },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Blue
                        )
                    )
                }
            }
        }

        Text(text = genderState)
    }
}