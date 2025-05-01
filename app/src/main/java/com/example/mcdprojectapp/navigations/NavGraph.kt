package com.example.mcdprojectapp.navigations

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mcdprojectapp.screens.AddFloorScreen
import com.example.mcdprojectapp.screens.AddOwnerScreen
import com.example.mcdprojectapp.screens.BottomNav
import com.example.mcdprojectapp.screens.CategoryDetailScreen
import com.example.mcdprojectapp.screens.HomeScreen
import com.example.mcdprojectapp.screens.LandAreaDetailsScreen
import com.example.mcdprojectapp.screens.OwnerDetailScreen2
import com.example.mcdprojectapp.screens.OwnerDetailsScreen
import com.example.mcdprojectapp.screens.ProfileScreen
import com.example.mcdprojectapp.screens.RequestScreen
import com.example.mcdprojectapp.screens.ServicesScreen
import com.example.mcdprojectapp.screens.SplashScreen
import com.example.mcdprojectapp.screens.TaxFactorDetails
import com.example.mcdprojectapp.screens.TaxFactorScreen
import com.example.mcdprojectapp.viewModel.SharedVM

@Composable
fun NavGraph(navHostController: NavHostController) {
    val sharedVM: SharedVM = viewModel()
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
            ServicesScreen(navHostController,sharedVM)
        }

        composable(Routes.Request.routes){
            RequestScreen(navHostController)
        }

        composable(Routes.BottomNav.routes){
            BottomNav(navHostController,sharedVM)
        }

        composable(Routes.CategoryDetail.routes){
            CategoryDetailScreen(navHostController)
        }

        composable(Routes.AddOwner.routes) {
            AddOwnerScreen(navHostController)
        }

        composable(Routes.OwnerDetails.routes){
            OwnerDetailsScreen(navHostController, sharedVM)
        }

        composable(Routes.OwnerDetails2.routes){
            OwnerDetailScreen2(navHostController, sharedVM)
        }

        composable(Routes.LandAreaDetails.routes){
            LandAreaDetailsScreen(navHostController)
        }

        composable(Routes.AddFloor.routes){
            AddFloorScreen(navHostController)
        }

        composable(Routes.TaxFactor.routes){
            TaxFactorScreen(navHostController)
        }

        composable(Routes.TaxFactorDetail.routes){
            TaxFactorDetails(navHostController)
        }

//        composable(Routes.ABC.routes){
//            val data = it.arguments?.getString("data")
//            OtherUserProfile(navController, data!!)
//        }

    }
}

