package com.example.mcdprojectapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mcdprojectapp.navigations.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//navController: NavHostController
fun ServicesScreen(navController: NavHostController){
    var showDialog by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()){
        val scrollState = rememberScrollState()

        Column(modifier = Modifier.padding(10.dp)
            .fillMaxSize().
            verticalScroll(scrollState)
        ){

            Text(text = "Enter Property Details",
                fontWeight = FontWeight.Medium,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.padding(10.dp))

            var colonyExpanded by remember { mutableStateOf(false) }
            var colonySelected by remember { mutableStateOf("") }
            val colonyList = listOf(
                "Ashok Vihar", "Greater Kailash", "Vasant Vihar", "Model Town",
                "Connaught Place", "Hauz Khas", "Punjabi Bagh", "Lajpat Nagar",
                "Saket", "Rohini", "Dwarka"
            )

            Text(text = "Colony Name")

            ExposedDropdownMenuBox(
                modifier = Modifier.padding(2.dp),
                expanded = colonyExpanded,
                onExpandedChange = { colonyExpanded = !colonyExpanded }
            ) {
                TextField(
                    value = colonySelected,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = colonyExpanded) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,  // Background color
                        unfocusedIndicatorColor = Color.Transparent, // Border when not focused
                        focusedIndicatorColor = Color.Transparent,   // Border when focused
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = MaterialTheme.shapes.small // Or RoundedCornerShape(4.dp)
                        )
                )

                ExposedDropdownMenu(
                    expanded = colonyExpanded,
                    onDismissRequest = { colonyExpanded = false }
                ) {
                    colonyList.forEach { colony ->
                        DropdownMenuItem(
                            text = { Text(colony) },
                            onClick = {
                                colonySelected = colony
                                colonyExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))

            var wardExpanded by remember { mutableStateOf(false) }
            var wardSelected by remember { mutableStateOf("") }

            Text(text = "Select Ward")

            ExposedDropdownMenuBox(
                modifier = Modifier.padding(2.dp),
                expanded = wardExpanded,
                onExpandedChange = { wardExpanded = !wardExpanded }
            ) {
                TextField(
                    value = wardSelected,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = wardExpanded) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,  // Background color
                        unfocusedIndicatorColor = Color.Transparent, // Border when not focused
                        focusedIndicatorColor = Color.Transparent,   // Border when focused
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = MaterialTheme.shapes.small // Or RoundedCornerShape(4.dp)
                        )
                )

                ExposedDropdownMenu(
                    expanded = wardExpanded,
                    onDismissRequest = { wardExpanded = false }
                ) {
                    colonyList.forEach { colony ->
                        DropdownMenuItem(
                            text = { Text(colony) },
                            onClick = {
                                wardSelected = colony
                                wardExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))

            var zoneExpanded by remember { mutableStateOf(false) }
            var zoneSelected by remember { mutableStateOf("") }
            val zoneList = listOf(
                "North Zone", "East Zone", "West Zone", "South Zone"
            )

            Text(text = "Select Zone")

            ExposedDropdownMenuBox(
                modifier = Modifier.padding(2.dp),
                expanded = zoneExpanded,
                onExpandedChange = { zoneExpanded = !zoneExpanded }
            ) {
                TextField(
                    value = zoneSelected,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = zoneExpanded) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,  // Background color
                        unfocusedIndicatorColor = Color.Transparent, // Border when not focused
                        focusedIndicatorColor = Color.Transparent,   // Border when focused
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = MaterialTheme.shapes.small // Or RoundedCornerShape(4.dp)
                        )
                )

                ExposedDropdownMenu(
                    expanded = zoneExpanded,
                    onDismissRequest = { zoneExpanded = false }
                ) {
                    zoneList.forEach { zone ->
                        DropdownMenuItem(
                            text = { Text(zone) },
                            onClick = {
                                zoneSelected = zone
                                zoneExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = "Enter Plot/House/Flat/Shop/Farm House Number")

            var plotNumber by remember { mutableStateOf("") }

            TextField(
                value = plotNumber,
                onValueChange = { plotNumber = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = MaterialTheme.shapes.small
                    )
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = "Sector/Phase Number")

            var phaseNumber by remember { mutableStateOf("") }

            TextField(
                value = phaseNumber,
                onValueChange = { phaseNumber = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = MaterialTheme.shapes.small
                    )
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = "Block/Pocket/Lane/Street")

            var blockNumber by remember { mutableStateOf("") }

            TextField(
                value = blockNumber,
                onValueChange = { blockNumber = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = MaterialTheme.shapes.small
                    )
            )

            Spacer(modifier = Modifier.padding(10.dp))

            var floorExpanded by remember { mutableStateOf(false) }
            var floorSelected by remember { mutableStateOf("") }
            val floorList = (1..50).toList()

            Text(text = "Floor Number")

            ExposedDropdownMenuBox(
                modifier = Modifier.padding(2.dp),
                expanded = floorExpanded,
                onExpandedChange = { floorExpanded = !floorExpanded }
            ) {
                TextField(
                    value = floorSelected,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = floorExpanded) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = MaterialTheme.shapes.small
                        )
                )

                ExposedDropdownMenu(
                    expanded = floorExpanded,
                    onDismissRequest = { floorExpanded = false }
                ) {
                    floorList.forEach { floor ->
                        DropdownMenuItem(
                            text = { Text("$floor") },
                            onClick = {
                                floorSelected = floor.toString()
                                floorExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = "Landmark or Additional Details")

            var landMark by remember { mutableStateOf("") }

            TextField(
                value = landMark,
                onValueChange = { landMark = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = MaterialTheme.shapes.small
                    )
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = "Pincode")

            var pincode by remember { mutableStateOf("") }

            TextField(
                value = pincode,
                onValueChange = { pincode = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = MaterialTheme.shapes.small
                    )
            )

            Spacer(modifier = Modifier.padding(10.dp))

            var stateExpanded by remember { mutableStateOf(false) }
            var stateSelected by remember { mutableStateOf("") }
            val stateList = listOf(
                "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
                "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand",
                "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur",
                "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
                "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
                "Uttar Pradesh", "Uttarakhand", "West Bengal", "Andaman and Nicobar Islands",
                "Chandigarh", "Dadra and Nagar Haveli and Daman and Diu", "Lakshadweep",
                "Delhi", "Puducherry"
            )

            Text(text = "State")

            ExposedDropdownMenuBox(
                modifier = Modifier.padding(2.dp),
                expanded = stateExpanded,
                onExpandedChange = { stateExpanded = !stateExpanded }
            ) {
                TextField(
                    value = stateSelected,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = stateExpanded) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,  // Background color
                        unfocusedIndicatorColor = Color.Transparent, // Border when not focused
                        focusedIndicatorColor = Color.Transparent,   // Border when focused
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = MaterialTheme.shapes.small // Or RoundedCornerShape(4.dp)
                        )
                )

                ExposedDropdownMenu(
                    expanded = stateExpanded,
                    onDismissRequest = { stateExpanded = false }
                ) {
                    stateList.forEach { state ->
                        DropdownMenuItem(
                            text = { Text(state) },
                            onClick = {
                                stateSelected = state
                                stateExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))

            var ctryExpanded by remember { mutableStateOf(false) }
            var ctrySelected by remember { mutableStateOf("") }
            val ctryList = listOf(
                "Afghanistan", "Argentina", "Australia", "Brazil", "Canada",
                "China", "France", "Germany", "India", "Italy",
                "Japan", "Mexico", "Russia", "South Africa", "United States"
            )

            Text(text = "Country")

            ExposedDropdownMenuBox(
                modifier = Modifier.padding(2.dp),
                expanded = ctryExpanded,
                onExpandedChange = { ctryExpanded = !ctryExpanded }
            ) {
                TextField(
                    value = ctrySelected,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = ctryExpanded) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,  // Background color
                        unfocusedIndicatorColor = Color.Transparent, // Border when not focused
                        focusedIndicatorColor = Color.Transparent,   // Border when focused
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = MaterialTheme.shapes.small // Or RoundedCornerShape(4.dp)
                        )
                )

                ExposedDropdownMenu(
                    expanded = ctryExpanded,
                    onDismissRequest = { ctryExpanded = false }
                ) {
                    ctryList.forEach { country ->
                        DropdownMenuItem(
                            text = { Text(country) },
                            onClick = {
                                ctrySelected = country
                                ctryExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Button(
                onClick = {
                    showDialog = true
                },
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF111184)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Proceed", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.padding(20.dp))
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {},
                dismissButton = {},
                title = null,
                containerColor = Color.White,
                text = {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "065001810000700",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(bottom = 24.dp)
                                .align(Alignment.Start)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            OutlinedButton(
                                onClick = { showDialog = false },
                                border = BorderStroke(1.dp, Color(0xFF111184)),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = Color(0xFF111184)
                                ),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text("Property Details", fontSize = 13.sp)
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Button(
                                onClick = {
                                    val route = Routes.CategoryDetail.routes
                                    navController.navigate(route)
                                    showDialog = false },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        0xFF111184
                                    )
                                ),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text("Continue", color = Color.White, fontSize = 13.sp)
                            }
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ServicePreview(){
    val navController = rememberNavController()
    ServicesScreen(navController)
}