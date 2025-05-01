package com.example.mcdprojectapp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mcdprojectapp.R
import com.example.mcdprojectapp.models.BottomNavItem
import com.example.mcdprojectapp.navigations.Routes
import com.example.mcdprojectapp.viewModel.SharedVM

@Composable
fun BottomNav(navController: NavHostController, sharedVM: SharedVM) {
    val navController1 = rememberNavController()
//    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    Scaffold(bottomBar = {
        MyBottomBar(navController1)
    }, topBar = {
        CustomAppBar(navController = navController1)
    }){ innerPadding->
        NavHost(
            navController = navController1,
            startDestination = Routes.Home.routes,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = Routes.Home.routes){
                HomeScreen(navController1)
            }

            composable(route = Routes.Services.routes){
                ServicesScreen(navController1,sharedVM)
            }

            composable(route = Routes.Request.routes){
                RequestScreen(navController1)
            }

            composable(Routes.Profile.routes){
                ProfileScreen(navController1)
            }

            composable(Routes.CategoryDetail.routes){
                CategoryDetailScreen(navController1)
            }

            composable(Routes.AddOwner.routes){
                AddOwnerScreen(navController1)
            }

            composable(Routes.OwnerDetails.routes){
                OwnerDetailsScreen(navController1,sharedVM)
            }

            composable(Routes.OwnerDetails2.routes){
                OwnerDetailScreen2(navController1,sharedVM)
            }

            composable(Routes.LandAreaDetails.routes){
                LandAreaDetailsScreen(navController1)
            }

            composable(Routes.AddFloor.routes){
                AddFloorScreen(navController1)
            }

            composable(Routes.TaxFactor.routes){
                TaxFactorScreen(navController1, sharedVM)
            }

            composable(Routes.TaxFactorDetail.routes){
                TaxFactorDetails(navController1, sharedVM)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    navController: NavHostController
) {
    TopAppBar(
        title = {
            Text(
                text = "Add New Property",
                fontSize = 18.sp,
            )
        },
        navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(22.dp)
                    )
                }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Back",
                    modifier = Modifier.size(22.dp)
                )
            }
        },
    )
}

@Composable
fun MyBottomBar(navController1: NavController){
    val backStackEntry = navController1.currentBackStackEntryAsState()
    val list = listOf(
        BottomNavItem(
            R.drawable.home_svgrepo_com,
            Routes.Home.routes,
            "Home"
        ),
        BottomNavItem(
            R.drawable.services_ic,
            Routes.Services.routes,
            "All Services"
        ),
        BottomNavItem(
            R.drawable.request_ic,
            Routes.Request.routes,
            "Requests"
        ),

        BottomNavItem(
            R.drawable.profile_ic,
            Routes.Profile.routes,
            "Profile"
        )
//        BottomNavItem(
//            Icons.Rounded.Notifications,
//            Routes.Notifications.routes,
//            "Notification"
//        ),

    )

    BottomAppBar {
        list.forEach{
            val selected = it.route == backStackEntry.value?.destination?.route
            NavigationBarItem(selected = selected, onClick = {
                navController1.navigate(it.route){
                    popUpTo(navController1.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                }
            }, icon = { Icon(painter = painterResource(it.icon), contentDescription = it.title)})
        }
    }
}