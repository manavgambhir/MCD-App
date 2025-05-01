package com.example.mcdprojectapp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mcdprojectapp.navigations.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandAreaDetailsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        UpicDetails()
        Spacer(modifier = Modifier.padding(20.dp))

        Text(
            text = "Enter Vacant / Land Area Details",
            fontWeight = FontWeight.Medium,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.padding(10.dp))

        var totalLandArea by remember { mutableStateOf("") }
        Text(text = "Total Land Area (In Sq. Mtr)(Scale Info)")

        TextField(
            value = totalLandArea,
            onValueChange = { totalLandArea = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        var groundCoveredArea by remember { mutableStateOf("") }
        Text(text = "Ground Covered Area (In Sq. Mtr)")
        TextField(
            value = groundCoveredArea,
            onValueChange = { groundCoveredArea = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        var vacantLand by remember { mutableStateOf("") }
        Text(text = "Vacant Land (In Sq. Mtr)")
        TextField(
            value = vacantLand,
            onValueChange = { vacantLand = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        val propertyTypeOptions = listOf("Residential", "Commercial", "Industrial")
        var propertyTypeExpanded by remember { mutableStateOf(false) }
        var selectedPropertyType by remember { mutableStateOf("") }
        Text(text = "Select Property Type")
        ExposedDropdownMenuBox(
            expanded = propertyTypeExpanded,
            onExpandedChange = { propertyTypeExpanded = !propertyTypeExpanded }
        ) {
            TextField(
                value = selectedPropertyType,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = propertyTypeExpanded)
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            ExposedDropdownMenu(
                expanded = propertyTypeExpanded,
                onDismissRequest = { propertyTypeExpanded = false }
            ) {
                propertyTypeOptions.forEach { property ->
                    DropdownMenuItem(
                        text = { Text(property) },
                        onClick = {
                            selectedPropertyType = property
                            propertyTypeExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        val useFactorOptions = listOf("Factor A", "Factor B", "Factor C")
        var useFactorExpanded by remember { mutableStateOf(false) }
        var selectedUseFactor by remember { mutableStateOf("") }

        Text(text = "Select Use Factor")
        ExposedDropdownMenuBox(
            expanded = useFactorExpanded,
            onExpandedChange = { useFactorExpanded = !useFactorExpanded }
        ) {
            TextField(
                value = selectedUseFactor,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
                    .padding(top = 4.dp)  // Matching padding from the first dropdown
                    .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small),  // Keeping the same border style
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = useFactorExpanded)
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            ExposedDropdownMenu(
                expanded = useFactorExpanded,
                onDismissRequest = { useFactorExpanded = false }
            ) {
                useFactorOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedUseFactor = option
                            useFactorExpanded = false
                        }
                    )
                }
            }
        }


        Spacer(modifier = Modifier.padding(10.dp))

        val occupationOptions = listOf("Occupied", "Vacant", "Under Construction")
        var occupationExpanded by remember { mutableStateOf(false) }
        var selectedOccupation by remember { mutableStateOf("") }

        Text(text = "Occupation Factor")
        ExposedDropdownMenuBox(
            expanded = occupationExpanded,
            onExpandedChange = { occupationExpanded = !occupationExpanded }
        ) {
            TextField(
                value = selectedOccupation,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
                    .padding(top = 4.dp)  
                    .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = occupationExpanded)
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            ExposedDropdownMenu(
                expanded = occupationExpanded,
                onDismissRequest = { occupationExpanded = false }
            ) {
                occupationOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedOccupation = option
                            occupationExpanded = false
                        }
                    )
                }
            }
        }


        Spacer(modifier = Modifier.padding(10.dp))

        val exemptionOptions = listOf("None", "Govt Approved", "NGO", "Special Zone")
        var exemptionExpanded by remember { mutableStateOf(false) }
        var selectedExemption by remember { mutableStateOf("") }

        Text(text = "Exemption")
        ExposedDropdownMenuBox(
            expanded = exemptionExpanded,
            onExpandedChange = { exemptionExpanded = !exemptionExpanded }
        ) {
            TextField(
                value = selectedExemption,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
                    .padding(top = 4.dp)
                    .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = exemptionExpanded)
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            ExposedDropdownMenu(
                expanded = exemptionExpanded,
                onDismissRequest = { exemptionExpanded = false }
            ) {
                exemptionOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedExemption = option
                            exemptionExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Button(
            onClick = {
                val route = Routes.AddFloor.routes
                navController.navigate(route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF111184)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Proceed", fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.padding(20.dp))
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsPreview(){
    val navController = rememberNavController()
    LandAreaDetailsScreen(navController = navController)
}