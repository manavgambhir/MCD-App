package com.example.mcdprojectapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mcdprojectapp.R

@Composable
fun FinalPropertyScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(R.drawable.f2), modifier = Modifier.fillMaxWidth().height(90.dp),
            contentDescription = "Body")

        Image(painter = painterResource(R.drawable.f1), modifier = Modifier.fillMaxSize().height(100.dp),
            contentDescription = "Logo")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FinalPreview(){
    val navController = rememberNavController()
    FinalPropertyScreen(navController = navController)
}