package com.sarvesh.jetcompose_modules.Buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonLayoutScreen(){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = { /*TODO*/ },
            elevation = ButtonDefaults.elevation(
                pressedElevation = 10.dp
            ),
            shape = CutCornerShape(10.dp),
            border = BorderStroke(2.dp, color = Color.Red),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Yellow,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Simple Button")
        }

        TextButton(onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors()
        ) {
            Text(text = "TextButton")
        }

        OutlinedButton(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Yellow
            )
        ) {
        }

    }

}