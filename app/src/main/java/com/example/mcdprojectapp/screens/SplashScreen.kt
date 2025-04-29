package com.example.mcdprojectapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.example.mcdprojectapp.navigations.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    Text("Splash Screen")

    LaunchedEffect(true) {
        delay(2000)
        navController.navigate(Routes.BottomNav.routes){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
        }
    }
}