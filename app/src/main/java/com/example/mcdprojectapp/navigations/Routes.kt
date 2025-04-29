package com.example.mcdprojectapp.navigations

sealed class Routes(val routes:String) {
    object BottomNav : Routes("bottomNav")
    object Home : Routes("home")
    object Profile : Routes("profile")
    object Services : Routes("services")
    object Request : Routes("request")
    object Splash : Routes("splash")
}