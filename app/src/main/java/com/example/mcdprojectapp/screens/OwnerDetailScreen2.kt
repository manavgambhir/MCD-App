package com.example.mcdprojectapp.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mcdprojectapp.itemView.OwnerDetailItem
import com.example.mcdprojectapp.models.OwnerDetails

@Composable
fun OwnerDetailScreen2(navController: NavHostController) {
    val owners = listOf(
        OwnerDetails(
            firstName = "Vikram",
            middleName = "Singh",
            lastName = "Rathod",
            gender = "Male",
            ownership = 100.0,
            email = "Winifred37@hotmail.com",
            ownerRebate = "123",
            address1 = "2298 S Front Street",
            address2 = "Port Alysson",
            pincode = 54305,
            state = "Maharashtra",
            country = "India"
        )
    )

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
                    fullName = owner.firstName,
                    gender = owner.gender,
                    ownership = owner.ownership,
                    email = owner.email,
                    rebate = owner.ownerRebate,
                    address = owner.address1,
                    onEditClick = { /* Handle edit */ },
                    onDeleteClick = { /* Handle delete */ }
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { /* Handle add new owner */ },
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
            }
        }

        Button(
            onClick = { /* Handle proceed */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF111184)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Proceed", fontSize = 16.sp, color = Color.White)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OwnerDetail2Preview(){
    val navController = rememberNavController()
    OwnerDetailScreen2(navController)
}