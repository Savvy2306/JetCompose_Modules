package com.sarvesh.jetcompose_modules.NavigationUsingVoyagr

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

object FirstScreen : Screen {

    @Composable
    override fun Content(){
        //through this navigator we will able to navigate
        //it will contain all info like backtrack, lifecycle , where will have to go
        val navigator = LocalNavigator.currentOrThrow

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                //push is infix function
                //this will help to navigate from one screen to another
                //navigator.push(SecondScreen)

                //to pass data from one screen to another
                navigator.push(ThirdScreen("Samar"))
            }) {
                Text(text = "Click Here")

            }

        }

    }
}