package com.sarvesh.jetcompose_modules.NavigationComponent.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarvesh.jetcompose_modules.NavigationComponent.screens.FirstScreen
import com.sarvesh.jetcompose_modules.NavigationComponent.screens.SecondScreen
import com.sarvesh.jetcompose_modules.NavigationComponent.utils.NavigationScreen

//to create nav host through with we can navigate between screens

@Composable
fun StartNavigation(context:Activity){

    //remember back stack like from where to where u r travelling
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavigationScreen.FirstScreen.route){
        composable(NavigationScreen.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(NavigationScreen.SecondScreen.route){
            //to receive data
            val data = it.arguments?.get("data")
            SecondScreen(navController)
        }
    }
}