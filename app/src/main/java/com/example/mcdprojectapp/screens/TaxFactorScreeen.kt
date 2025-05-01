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
fun TaxFactorScreen(navController: NavHostController) {
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
            text = "Tax Factors for Section/Floor",
            fontWeight = FontWeight.Medium,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Text(text = "Floor/Section: 01", fontSize = 18.sp)

        Spacer(modifier = Modifier.padding(20.dp))

        val floorOptions = listOf("Floor 1", "Floor 2", "Floor 3", "Floor 4")
        var floorExpanded by remember { mutableStateOf(false) }
        var selectedFloor by remember { mutableStateOf("") }

        Text(text = "Select Floor")
        ExposedDropdownMenuBox(
            expanded = floorExpanded,
            onExpandedChange = { floorExpanded = !floorExpanded }
        ) {
            TextField(
                value = selectedFloor,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = floorExpanded)
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
                expanded = floorExpanded,
                onDismissRequest = { floorExpanded = false }
            ) {
                floorOptions.forEach { floor ->
                    DropdownMenuItem(
                        text = { Text(floor) },
                        onClick = {
                            selectedFloor = floor
                            floorExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        var coveredArea by remember { mutableStateOf("") }
        Text(text = "Covered Area / Super Area (In Sq. Mtr.)")
        TextField(
            value = coveredArea,
            onValueChange = { coveredArea = it },
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

        val ageFactorOptions = listOf("Before 1980", "1980-2000", "2000-2010", "After 2010")
        var ageFactorExpanded by remember { mutableStateOf(false) }
        var selectedAgeFactor by remember { mutableStateOf("") }

        Text(text = "Age Factor (Year of Construction)")
        ExposedDropdownMenuBox(
            expanded = ageFactorExpanded,
            onExpandedChange = { ageFactorExpanded = !ageFactorExpanded }
        ) {
            TextField(
                value = selectedAgeFactor,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = ageFactorExpanded)
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
                expanded = ageFactorExpanded,
                onDismissRequest = { ageFactorExpanded = false }
            ) {
                ageFactorOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedAgeFactor = option
                            ageFactorExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        val propertyCategoryOptions = listOf("Residential", "Commercial", "Industrial")
        var propertyCategoryExpanded by remember { mutableStateOf(false) }
        var selectedPropertyCategory by remember { mutableStateOf("") }

        Text(text = "Property Category")
        ExposedDropdownMenuBox(
            expanded = propertyCategoryExpanded,
            onExpandedChange = { propertyCategoryExpanded = !propertyCategoryExpanded }
        ) {
            TextField(
                value = selectedPropertyCategory,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = propertyCategoryExpanded)
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
                expanded = propertyCategoryExpanded,
                onDismissRequest = { propertyCategoryExpanded = false }
            ) {
                propertyCategoryOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedPropertyCategory = option
                            propertyCategoryExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        val propertyTypeOptions = listOf("Residential", "Commercial", "Industrial")
        var propertyTypeExpanded by remember { mutableStateOf(false) }
        var selectedPropertyType by remember { mutableStateOf("") }

        Text(text = "Property Type")
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
                propertyTypeOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedPropertyType = option
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

        Text(text = "Use Factor")
        ExposedDropdownMenuBox(
            expanded = useFactorExpanded,
            onExpandedChange = { useFactorExpanded = !useFactorExpanded }
        ) {
            TextField(
                value = selectedUseFactor,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = useFactorExpanded)
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

        val structureFactorOptions = listOf("Factor X", "Factor Y", "Factor Z")
        var structureFactorExpanded by remember { mutableStateOf(false) }
        var selectedStructureFactor by remember { mutableStateOf("") }

        Text(text = "Structure Factor")
        ExposedDropdownMenuBox(
            expanded = structureFactorExpanded,
            onExpandedChange = { structureFactorExpanded = !structureFactorExpanded }
        ) {
            TextField(
                value = selectedStructureFactor,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = structureFactorExpanded)
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
                expanded = structureFactorExpanded,
                onDismissRequest = { structureFactorExpanded = false }
            ) {
                structureFactorOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedStructureFactor = option
                            structureFactorExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        val occupancyFactorOptions = listOf("Occupied", "Vacant", "Under Construction")
        var occupancyFactorExpanded by remember { mutableStateOf(false) }
        var selectedOccupancyFactor by remember { mutableStateOf("") }

        Text(text = "Occupancy Factor")
        ExposedDropdownMenuBox(
            expanded = occupancyFactorExpanded,
            onExpandedChange = { occupancyFactorExpanded = !occupancyFactorExpanded }
        ) {
            TextField(
                value = selectedOccupancyFactor,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = occupancyFactorExpanded)
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
                expanded = occupancyFactorExpanded,
                onDismissRequest = { occupancyFactorExpanded = false }
            ) {
                occupancyFactorOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedOccupancyFactor = option
                            occupancyFactorExpanded = false
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
                val route = Routes.TaxFactorDetail.routes
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
fun TaxFactorPreview(){
    val navController = rememberNavController()
    TaxFactorScreen(navController = navController)
}