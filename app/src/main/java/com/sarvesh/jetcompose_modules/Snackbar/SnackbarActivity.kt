package com.sarvesh.jetcompose_modules.Snackbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import com.sarvesh.jetcompose_modules.ui.theme.JetCompose_ModulesTheme

class SnackbarActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            JetCompose_ModulesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val scaffoldState = rememberScaffoldState()
                    Scaffold(scaffoldState = scaffoldState) {it
                        SnackbarScreen(scaffoldState = scaffoldState)
                    }
                }
            }
        }
    }
}