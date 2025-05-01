package com.example.mcdprojectapp.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.mcdprojectapp.models.OwnerDetails
import com.example.mcdprojectapp.models.TaxFactorDetail

class SharedVM : ViewModel() {
    // List of owner details stored in memory (doesn't persist across app restarts)
    private val _owners: SnapshotStateList<OwnerDetails> = mutableStateListOf()

    private val _taxFactor: SnapshotStateList<TaxFactorDetail> = mutableStateListOf()

    // Expose the list of owners directly as State
    val owners: List<OwnerDetails> get() = _owners

    val taxFactor: List<TaxFactorDetail> get() = _taxFactor

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

    fun addTaxFactor(taxFactor: TaxFactorDetail) {
        _taxFactor.add(taxFactor)
    }

    fun removeTaxFactor(taxFactor: TaxFactorDetail) {
        _taxFactor.remove(taxFactor)
    }

    fun clearTaxFactor() {
        _taxFactor.clear()
    }
}
