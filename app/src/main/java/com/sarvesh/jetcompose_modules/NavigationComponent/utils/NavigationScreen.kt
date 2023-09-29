package com.sarvesh.jetcompose_modules.NavigationComponent.utils

//through which we will provide unique tag name to both screen

sealed class NavigationScreen(val route: String){
    object FirstScreen : NavigationScreen("firstscreen")
    //object SecondScreen : NavigationScreen("secondscreen")
    //to pass data from one screen to another
    object SecondScreen : NavigationScreen("secondscreen"){
        fun createRoute(data:String) = "$data/secondscreen"
        //now we will call create route on first screen and it will pass data from first to second
    }
    object ThirdScreen : NavigationScreen("thirdscreen")
}
