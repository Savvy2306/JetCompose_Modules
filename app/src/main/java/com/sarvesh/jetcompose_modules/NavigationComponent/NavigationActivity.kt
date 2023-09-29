package com.sarvesh.jetcompose_modules.NavigationComponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.sarvesh.jetcompose_modules.NavigationComponent.navigation.StartNavigation
import com.sarvesh.jetcompose_modules.ui.theme.JetCompose_ModulesTheme

class NavigationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            JetCompose_ModulesTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    StartNavigation(this)
                }
            }
        }
    }
}