package com.example.mcdprojectapp.screens

import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailScreen(navController: NavHostController) {

    Column(modifier = Modifier.padding(10.dp)
        .fillMaxSize()
    ){
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("UPIC ID")

            Spacer(modifier = Modifier.padding(4.dp))

            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info",
                modifier = Modifier.size(16.dp)
            )

            Text("065001810000700", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)
        }


        Spacer(modifier = Modifier.padding(20.dp))

        Text(text = "Enter Category Details",
            fontWeight = FontWeight.Medium,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.padding(10.dp))

        var categoryExpanded by remember { mutableStateOf(false) }
        var categorySelected by remember { mutableStateOf("") }
        val categoryList = listOf(
            "Individual",
            "Company",
            "Government",
            "Cooperative Society",
            "Joint Ownership",
            "Trust"
        )


        Text(text = "Ownership Category")

        ExposedDropdownMenuBox(
            modifier = Modifier.padding(2.dp),
            expanded = categoryExpanded,
            onExpandedChange = { categoryExpanded = !categoryExpanded }
        ) {
            TextField(
                value = categorySelected,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = categoryExpanded) },
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
                expanded = categoryExpanded,
                onDismissRequest = { categoryExpanded = false }
            ) {
                categoryList.forEach { category ->
                    DropdownMenuItem(
                        text = { Text(category) },
                        onClick = {
                            categorySelected = category
                            categoryExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        var typeExpanded by remember { mutableStateOf(false) }
        var typeSelected by remember { mutableStateOf("") }
        val typeList = listOf(
            "Single Owner",
            "Co-owner",
            "Leaseholder",
            "Tenant",
            "Custodian"
        )

        Text(text = "Ownership Type")

        ExposedDropdownMenuBox(
            modifier = Modifier.padding(2.dp),
            expanded = typeExpanded,
            onExpandedChange = { typeExpanded = !typeExpanded }
        ) {
            TextField(
                value = typeSelected,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = typeExpanded) },
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
                expanded = typeExpanded,
                onDismissRequest = { typeExpanded = false }
            ) {
                typeList.forEach { type ->
                    DropdownMenuItem(
                        text = { Text(type) },
                        onClick = {
                            typeSelected = type
                            typeExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        var propertyExpanded by remember { mutableStateOf(false) }
        var propertySelected by remember { mutableStateOf("") }
        val propertyCategoryList = listOf(
            "Residential",
            "Commercial",
            "Industrial",
            "Institutional",
            "Mixed-Use",
            "Agricultural"
        )


        Text(text = "Property Category")

        ExposedDropdownMenuBox(
            modifier = Modifier.padding(2.dp),
            expanded = propertyExpanded,
            onExpandedChange = { propertyExpanded = !propertyExpanded }
        ) {
            TextField(
                value = propertySelected,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = propertyExpanded) },
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
                expanded = propertyExpanded,
                onDismissRequest = { propertyExpanded = false }
            ) {
                propertyCategoryList.forEach { property ->
                    DropdownMenuItem(
                        text = { Text(property) },
                        onClick = {
                            propertySelected = property
                            propertyExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Is your property among DDA/CGHS/JANTA/BUILDER FLAT OR BUILDER FLOOR ?")

        var selectedOption by remember { mutableStateOf("Yes") }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedOption == "Yes",
                    onClick = { selectedOption = "Yes" }
                )
                Text("Yes")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedOption == "No",
                    onClick = { selectedOption = "No" }
                )
                Text("No")
            }
        }

        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End,modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = {
                    // TODO:
                },
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = 30.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF111184)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Proceed", fontSize = 16.sp)
            }

//            Spacer(modifier = Modifier.padding(20.dp))
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryPreview(){
    val navController = rememberNavController()
    CategoryDetailScreen(navController = navController)
}