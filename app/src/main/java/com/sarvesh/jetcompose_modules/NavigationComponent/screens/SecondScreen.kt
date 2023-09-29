package com.sarvesh.jetcompose_modules.NavigationComponent.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.sarvesh.jetcompose_modules.NavigationComponent.utils.NavigationScreen

@Composable
fun SecondScreen(navController: NavHostController){
    Button(onClick = {
        navController.navigate(NavigationScreen.ThirdScreen.route ) {
            //to move to first from third without moving to second
            popUpTo(NavigationScreen.FirstScreen.route) {

            //to remove first and second both
                //inclusive to mean remove all screen
                //inclusive false means remove all till first
            inclusive = true

        }
            //to follow A->B->C and will not repeat again either screen
            //it will create only single instance
            //launchSingleTop=true
        }
    }) {
        Text(text = "Another Activity")
    }
}