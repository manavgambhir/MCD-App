package com.example.mcdprojectapp.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mcdprojectapp.models.OwnerDetails

class SharedVM : ViewModel() {
    // List of owner details stored in memory (doesn't persist across app restarts)
    private val _owners: SnapshotStateList<OwnerDetails> = mutableStateListOf()

    // Expose the list of owners directly as State
    val owners: List<OwnerDetails> get() = _owners

    // Function to add an owner to the list
    fun addOwner(owner: OwnerDetails) {
        _owners.add(owner)
    }

    // Function to remove an owner from the list
    fun removeOwner(owner: OwnerDetails) {
        _owners.remove(owner)
    }

    // Function to clear all owners
    fun clearOwners() {
        _owners.clear()
    }
}
