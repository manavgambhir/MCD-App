package com.example.mcdprojectapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mcdprojectapp.screens.AddOwnerScreen
import com.example.mcdprojectapp.screens.BottomNav
import com.example.mcdprojectapp.screens.CategoryDetailScreen
import com.example.mcdprojectapp.screens.HomeScreen
import com.example.mcdprojectapp.screens.OwnerDetailsScreen
import com.example.mcdprojectapp.screens.ProfileScreen
import com.example.mcdprojectapp.screens.RequestScreen
import com.example.mcdprojectapp.screens.ServicesScreen
import com.example.mcdprojectapp.screens.SplashScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.Splash.routes){
        composable(Routes.Splash.routes){
            SplashScreen(navHostController)
        }

        composable(Routes.Home.routes){
            HomeScreen(navHostController)
        }

        composable(Routes.Profile.routes){
            ProfileScreen(navHostController)
        }

        composable(Routes.Services.routes){
            ServicesScreen(navHostController)
        }

        composable(Routes.Request.routes){
            RequestScreen(navHostController)
        }

        composable(Routes.BottomNav.routes){
            BottomNav(navHostController)
        }

        composable(Routes.CategoryDetail.routes){
            CategoryDetailScreen(navHostController)
        }

        composable(Routes.AddOwner.routes) {
            AddOwnerScreen(navHostController)
        }

        composable(Routes.OwnerDetails.routes){
            OwnerDetailsScreen(navHostController)
        }
//
//        composable(Routes.ABC.routes){
//            val data = it.arguments?.getString("data")
//            OtherUserProfile(navController, data!!)
//        }

    }
}

