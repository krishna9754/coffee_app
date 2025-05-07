package com.example.practice.ui.appui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.practice.MVVM.viewModel.UserViewModel
import com.example.practice.R
import com.example.practice.ui.common.ScaffoldBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressScreen(
    navController: NavHostController,
    userViewModel: UserViewModel = hiltViewModel(),
    coffeeId: String
) = ScaffoldBar(
    title = R.string.address,
    appBarColor = TopAppBarDefaults.topAppBarColors(Color.Transparent)
) {

    LaunchedEffect(Unit) {
        userViewModel.getAllUsers()
    }


    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(it)
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        CustomNameText(
            text = "Name",
            textValue = userViewModel.name,
            changeValue = userViewModel::onNameChange,
            placeholder = "Enter Name"
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomNameText(
            text = "Mobile no.",
            textValue = userViewModel.phone,
            changeValue = userViewModel::onPhoneChange,
            placeholder = "Mobile no.",
            keyBoardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomNameText(
            text = "City",
            textValue = userViewModel.city,
            changeValue = userViewModel::onCityChange,
            placeholder = "City"
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomNameText(
            text = "State",
            textValue = userViewModel.state,
            changeValue = userViewModel::onStateChange,
            placeholder = "State"
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomNameText(
            text = "Pincode",
            textValue = userViewModel.pincode,
            changeValue = userViewModel::onPincodeChange,
            placeholder = "Pincode",
            keyBoardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomNameText(
            text = "Address",
            textValue = userViewModel.address,
            changeValue = userViewModel::onAddressChange,
            placeholder = "Full Address...",
            minLines = 4,
            imeAction = ImeAction.Done
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (
                    userViewModel.name.isNotBlank() &&
                    userViewModel.phone.isNotBlank() &&
                    userViewModel.city.isNotBlank() &&
                    userViewModel.state.isNotBlank() &&
                    userViewModel.address.isNotBlank() &&
                    userViewModel.pincode.isNotBlank()
                ) {
                    scope.launch {
                            userViewModel.saveUserAddress()
                        if (userViewModel.insertSuccess) {
                            Toast.makeText(context, "Address Saved", Toast.LENGTH_SHORT).show()
                            navController.popBackStack()
                        }
                    }
                } else {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(Color(0xfff5b419)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Save")
        }
    }
}


@Composable
private fun CustomNameText(
    text: String = "",
    textValue: String = "",
    changeValue: (String) -> Unit = {},
    placeholder: String = "",
    minLines: Int = 1,
    keyBoardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next
) {
    Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = textValue,
        onValueChange = changeValue,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = placeholder, color = Color.LightGray) },
        maxLines = minLines,
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyBoardType
        ),
    )
}