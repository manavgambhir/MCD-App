package com.example.mcdprojectapp.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mcdprojectapp.navigations.Routes
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OwnerDetailsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    var firstName by remember { mutableStateOf("") }
    var middleName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pan by remember { mutableStateOf("") }
    var ownership by remember { mutableStateOf("") }

    val context = LocalContext.current
    val calendar = remember { Calendar.getInstance() }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        UpicDetails()

        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Enter Owner Details",
            fontWeight = FontWeight.Medium,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = "First Name")
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
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

        Text(text = "Middle Name")
        TextField(
            value = middleName,
            onValueChange = { middleName = it },
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

        Text(text = "Last Name")
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
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

        Text(text = "Gender")
        var genderExpanded by remember { mutableStateOf(false) }
        val genderOptions = listOf("Male", "Female", "Other")

        ExposedDropdownMenuBox(
            expanded = genderExpanded,
            onExpandedChange = { genderExpanded = !genderExpanded }
        ) {
            TextField(
                value = gender,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = genderExpanded)
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
                expanded = genderExpanded,
                onDismissRequest = { genderExpanded = false }
            ) {
                genderOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            gender = option
                            genderExpanded = false
                        }
                    )
                }
            }
        }


        Spacer(modifier = Modifier.padding(10.dp))

        // TODO: OnClick Functionality not working
        val datePickerDialog = remember {
            DatePickerDialog(
                context,
                { _, year, month, dayOfMonth ->
                    dob = "$dayOfMonth/${month + 1}/$year"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
        }

        val interactionSource = remember { MutableInteractionSource() }

        Text(text = "Date of Birth")

        TextField(
            value = dob,
            onValueChange = {}, // Since it's read-only
            readOnly = true,
            leadingIcon = {
                Icon(Icons.Default.DateRange, contentDescription = "DOB")
            },
            interactionSource = interactionSource,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    datePickerDialog.show()
                },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = "Age (As On 30th June of Financial year)")
        TextField(
            value = age,
            onValueChange = { age = it },
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

        Text(text = "Phone Number")
        TextField(
            value = phone,
            onValueChange = { phone = it },
            leadingIcon = {
                Icon(Icons.Default.Phone, contentDescription = "Phone")
            },
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

        Text(text = "Email")
        TextField(
            value = email,
            onValueChange = { email = it },
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

        Text(text = "Pan")
        TextField(
            value = pan,
            onValueChange = { pan = it },
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

        Text(text = "Ownership Percentage")
        TextField(
            value = ownership,
            onValueChange = { ownership = it },
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
        Text(text = "Owner Rebate")

        var rebateExpanded by remember { mutableStateOf(false) }
        var rebateSelected by remember { mutableStateOf("") }
        val rebateList = listOf("None", "Senior Citizen", "Freedom Fighter", "Ex-Serviceman")

        ExposedDropdownMenuBox(
            modifier = Modifier.padding(2.dp),
            expanded = rebateExpanded,
            onExpandedChange = { rebateExpanded = !rebateExpanded }
        ) {
            TextField(
                value = rebateSelected,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = rebateExpanded)
                },
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
                    .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
            )

            ExposedDropdownMenu(
                expanded = rebateExpanded,
                onDismissRequest = { rebateExpanded = false }
            ) {
                rebateList.forEach { rebate ->
                    DropdownMenuItem(
                        text = { Text(rebate) },
                        onClick = {
                            rebateSelected = rebate
                            rebateExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = "Owner's Correspondence Address Same As Property Address")

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

        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = "Address Line 1")
        var addressLine1 by remember { mutableStateOf("") }
        TextField(
            value = addressLine1,
            onValueChange = { addressLine1 = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 10.dp)
                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            singleLine = false,
            maxLines = 4
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = "Address Line 2")
        var addressLine2 by remember { mutableStateOf("") }
        TextField(
            value = addressLine2,
            onValueChange = { addressLine2 = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 10.dp)
                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            singleLine = false,
            maxLines = 4
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
                .padding(top = 4.dp, bottom = 10.dp)
                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        // TODO: Full state list
        Text(text = "State")
        var stateExpanded by remember { mutableStateOf(false) }
        var stateSelected by remember { mutableStateOf("") }
        val stateList = listOf("Delhi", "Haryana", "Uttar Pradesh", "Maharashtra")

        ExposedDropdownMenuBox(
            modifier = Modifier.padding(2.dp),
            expanded = stateExpanded,
            onExpandedChange = { stateExpanded = !stateExpanded }
        ) {
            TextField(
                value = stateSelected,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = stateExpanded)
                },
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
                    .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
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

        // TODO: Full country list
        Text(text = "Country")
        var countryExpanded by remember { mutableStateOf(false) }
        var countrySelected by remember { mutableStateOf("") }
        val countryList = listOf("India", "Nepal", "Bhutan", "Bangladesh")

        ExposedDropdownMenuBox(
            modifier = Modifier.padding(2.dp),
            expanded = countryExpanded,
            onExpandedChange = { countryExpanded = !countryExpanded }
        ) {
            TextField(
                value = countrySelected,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = countryExpanded)
                },
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
                    .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
            )

            ExposedDropdownMenu(
                expanded = countryExpanded,
                onDismissRequest = { countryExpanded = false }
            ) {
                countryList.forEach { country ->
                    DropdownMenuItem(
                        text = { Text(country) },
                        onClick = {
                            countrySelected = country
                            countryExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = "Select District")
        var districtExpanded by remember { mutableStateOf(false) }
        var districtSelected by remember { mutableStateOf("") }
        val districtList = listOf("Central", "East", "West", "North", "South")

        ExposedDropdownMenuBox(
            modifier = Modifier.padding(2.dp),
            expanded = districtExpanded,
            onExpandedChange = { districtExpanded = !districtExpanded }
        ) {
            TextField(
                value = districtSelected,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = districtExpanded)
                },
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
                    .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
            )

            ExposedDropdownMenu(
                expanded = districtExpanded,
                onDismissRequest = { districtExpanded = false }
            ) {
                districtList.forEach { district ->
                    DropdownMenuItem(
                        text = { Text(district) },
                        onClick = {
                            districtSelected = district
                            districtExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Button(
            onClick = {
                val route = Routes.OwnerDetails2.routes
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
fun OwnerDetailPreview(){
    val navController = rememberNavController()
    OwnerDetailsScreen(navController)
}