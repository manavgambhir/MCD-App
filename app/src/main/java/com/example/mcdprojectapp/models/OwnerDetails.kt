package com.example.mcdprojectapp.models

data class OwnerDetails(
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val gender: String,
    val ownership: Double,
    val email: String,
    val ownerRebate: String,
    val address1: String,
    val address2: String,
    val pincode: Int,
    val state: String,
    val country: String,
)
