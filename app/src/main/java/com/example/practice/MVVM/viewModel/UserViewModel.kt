package com.example.practice.MVVM.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.MVVM.data.UserData
import com.example.practice.MVVM.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var insertSuccess by mutableStateOf(false)

    var name by mutableStateOf("")
    var address by mutableStateOf("")
    var phone by mutableStateOf("")
    var pincode by mutableStateOf("")
    var city by mutableStateOf("")
    var state by mutableStateOf("")
    val userId: Int? = null

    private val _userAddresses = MutableStateFlow<List<UserData>>(emptyList())
    val userAddresses: StateFlow<List<UserData>> = _userAddresses.asStateFlow()

    private val _selectedAddress = MutableStateFlow<UserData?>(null)
    val selectedAddress: StateFlow<UserData?> = _selectedAddress

    fun onNameChange(newName: String) { name = newName }
    fun onAddressChange(newAddress: String) { address = newAddress }
    fun onPhoneChange(newPhone: String) { phone = newPhone }
    fun onPincodeChange(newPincode: String) { pincode = newPincode }
    fun onCityChange(newCity: String) { city = newCity }
    fun onStateChange(newState: String) { state = newState }

    fun selectAddress(address: UserData) {
        _selectedAddress.value = address
    }


    fun saveUserAddress() {
        viewModelScope.launch {
            val user = UserData(
                name = name,
                address = address,
                phone = phone,
                pincode = pincode,
                city = city,
                state = state
            )
            repository.insertUser(user)
            getAllUsers()
//            clearFields()
        }
    }

    fun getAllUsers() {
        viewModelScope.launch {
            repository.getAllUser().collect {
                _userAddresses.value = it
            }
        }
    }

    private fun clearFields() {
        name = ""
        address = ""
        phone = ""
        pincode = ""
        city = ""
        state = ""
    }
}