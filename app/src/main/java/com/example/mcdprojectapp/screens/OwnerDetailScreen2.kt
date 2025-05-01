package com.example.mcdprojectapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mcdprojectapp.itemView.OwnerDetailItem
import com.example.mcdprojectapp.navigations.Routes
import com.example.mcdprojectapp.viewModel.SharedVM

@Composable
fun OwnerDetailScreen2(navController: NavHostController, sharedVM: SharedVM) {
    val owners by remember { mutableStateOf(sharedVM.owners) }
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()

    ) {
        UpicDetails()

        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Owner Details",
            fontWeight = FontWeight.Medium,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.padding(10.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(owners) { owner ->
                OwnerDetailItem(
                    fullName = if(owner.middleName.isNotBlank()){
                        owner.firstName+" "+owner.middleName+" "+owner.lastName
                    } else{
                        owner.firstName+" "+owner.lastName
                    },
                    gender = owner.gender,
                    ownership = owner.ownership,
                    email = owner.email,
                    rebate = owner.ownerRebate,
                    address = if(owner.address2.isNotBlank()){
                        owner.address1+", "+owner.address2+", "+owner.state
                    }else{
                        owner.address1+", "+owner.state
                    },
                    onEditClick = {  },
                    onDeleteClick = {
                        sharedVM.removeOwner(owner)
                    }
                )
                Spacer(modifier = Modifier.padding(4.dp))
            }



            item {
                Spacer(modifier = Modifier.padding(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            val route = Routes.OwnerDetails.routes
                            navController.navigate(route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color.Blue
                        ),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Owner",
                            modifier = Modifier.size(20.dp))

                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Add New Owner", fontSize = 16.sp)
                    }
                }
                Spacer(modifier = Modifier.padding(4.dp))
            }
        }

        Column(verticalArrangement = Arrangement.Bottom) {
            Button(
                onClick = {
                    val route = Routes.LandAreaDetails.routes
                    navController.navigate(route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF111184)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Proceed", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OwnerDetail2Preview(){
    val navController = rememberNavController()
//    OwnerDetailScreen2(navController, sharedVM)
}