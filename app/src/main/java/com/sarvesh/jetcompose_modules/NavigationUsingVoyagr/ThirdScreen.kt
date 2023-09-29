package com.sarvesh.jetcompose_modules.NavigationUsingVoyagr

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

//creating this screen for scenario if we pass data fron one screen to another
data class ThirdScreen(
    val name:String
):Screen {
    @Composable
    override fun Content(){
        Text(text = "Hi $name")
    }
}