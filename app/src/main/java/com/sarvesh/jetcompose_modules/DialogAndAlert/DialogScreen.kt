package com.sarvesh.jetcompose_modules.DialogAndAlert

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog

//below code to show dialog

@Composable
fun DialogScreen() {

    var isDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            isDialog = true
        }) {
            Text(text = "CLick Here")
        }
    }

    if (isDialog)

        Dialog(onDismissRequest = {
            isDialog = false
        }) {
            //to show progress bar indicator
            CircularProgressIndicator()
        }
}

//  below code to show alert

@Composable
fun AlertDialogScreen(){

    var isAlert by remember {
        mutableStateOf(false)
    }
    
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = { isAlert=true }) {
            Text(text = "Open Alert")
        }

    }

    if (isAlert)
        AlertDialog(onDismissRequest = { isAlert = false },
        title = {
            Text(text = "This Is Alert Dialog")
        },
        modifier = Modifier.fillMaxWidth(),
            buttons = {
                Button(onClick = {isAlert = false },
                   ) {
                    Text(text = "Ok")
                }
            }
        )
}
