package com.example.mcdprojectapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mcdprojectapp.R
import com.example.mcdprojectapp.navigations.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    Box(modifier = Modifier.fillMaxSize().background(Color.Black), contentAlignment = Alignment.Center){
        Image(painter = painterResource(R.drawable.mcd),
            contentDescription = "Logo",
            modifier = Modifier.size(150.dp))
    }

    LaunchedEffect(true) {
        delay(2000)
        navController.navigate(Routes.BottomNav.routes){
            popUpTo(Routes.Splash.routes) { inclusive = true }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashPreview(){
    val navController = rememberNavController()
    SplashScreen(navController = navController)
}