package com.sarvesh.jetcompose_modules.NavigationDrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import com.sarvesh.jetcompose_modules.ui.theme.JetCompose_ModulesTheme
import kotlinx.coroutines.launch

class NavigationDrawerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            JetCompose_ModulesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val scaffoldState = rememberScaffoldState()
                    val scope = rememberCoroutineScope()
                    Scaffold(
                        scaffoldState = scaffoldState,
                        drawerContent = {
                            Column() {
                                IconButton(onClick = {
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }) {
                                    Icon(Icons.Default.Close, contentDescription ="", tint = Color.Blue )
                                }
                                Text(text = "Drawer Content")
                            }
                        },
                        drawerGesturesEnabled = false
                    ) {it
                        NavigationDrawerScreen(scaffoldState = scaffoldState)
                    }
                }
            }
        }
    }
    
}