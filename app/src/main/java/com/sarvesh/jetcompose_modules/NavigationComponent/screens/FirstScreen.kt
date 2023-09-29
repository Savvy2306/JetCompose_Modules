package com.sarvesh.jetcompose_modules.NavigationComponent.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.sarvesh.jetcompose_modules.NavigationComponent.utils.NavigationScreen

@Composable
fun FirstScreen(navController: NavHostController) {
    /*Button(onClick = {navController.navigate(NavigationScreen.SecondScreen.route )}) {
        Text(text = "Click")
        
    }*/
    //passing data to second screen by calling create route
    Button(onClick = {navController.navigate(NavigationScreen.SecondScreen.createRoute("Hi Samar") )}) {
        Text(text = "Click")

    }

}

//A->B->C        C->A