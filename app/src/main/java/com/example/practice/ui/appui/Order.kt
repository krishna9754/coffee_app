package com.example.practice.ui.appui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.practice.MVVM.data.CoffeeData
import com.example.practice.MVVM.viewModel.UserViewModel
import com.example.practice.R
import com.example.practice.destination.Sealed
import com.example.practice.ui.common.ScaffoldBar
import com.exyte.animatednavbar.utils.noRippleClickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Order(
    onBack: () -> Boolean,
    coffee: CoffeeData,
    navController: NavHostController,
    userViewModel: UserViewModel = hiltViewModel()
) {
    val selectedAddress by userViewModel.selectedAddress.collectAsState()
    val userAddresses by userViewModel.userAddresses.collectAsState()
    var items by remember { mutableIntStateOf(1) }

    val deliveryFee = 1.0
    val coffeePrice = coffee.price?.toDoubleOrNull() ?: 0.0
    val totPrice = coffeePrice * items
    val totalPayment = totPrice + deliveryFee

    ScaffoldBar(
    title = R.string.order,
    Icon = null,
    onBack = { onBack.invoke() },
    bottomBar = { BootomBB(navController, coffee, totalPayment, items) },
    appBarColor = TopAppBarDefaults.topAppBarColors(Color.Transparent)
) {


    LaunchedEffect(Unit) {
        userViewModel.getAllUsers()
    }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(horizontal = 25.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Delivery Address",
            modifier = Modifier.padding(top = 20.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp))

        userAddresses.forEach { address ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .noRippleClickable {
                        userViewModel.selectAddress(address)
                    },
                colors = CardDefaults.cardColors(
                    containerColor = if (selectedAddress == address) Color(0xFFFFF3E0) else Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(text = address.name ?: "")
                    Text(text = "${address.address}, ${address.city}, ${address.state} - ${address.pincode}")
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Phone: ${address.phone}")
                        if (selectedAddress != address) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete",
                                modifier = Modifier.clickable {
                                    userViewModel.deleteUser(address)
                                }
                            )
                        }
                    }
                }
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            onClick = { navController.navigate("${Sealed.Address.name}/${coffee.id}") },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xfff5b419))
        ) {
            Text(text = "Add New Address")
        }

        HorizontalDivider(modifier = Modifier.padding(top = 20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                modifier = Modifier.padding(top = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.coffie),
                    contentDescription = ""
                )
                Text(
                    text = coffee.title,
                    fontSize = 15.sp,
                    modifier = Modifier.width(150.dp)
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_subtract),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .noRippleClickable { if (items >= 2) items -= 1 },
                )
                Text(
                    text = "$items",
                    fontSize = 20.sp,
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .noRippleClickable { items += 1 }
                )
            }
        }

        HorizontalDivider(modifier = Modifier.padding(top = 20.dp), thickness = 4.dp)

        Card(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Color.Transparent),
            border = BorderStroke(width = 1.dp, color = Color(0xffEAEAEA))
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_discount),
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
                Text(text = "1 Discount is applied")
                Image(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth(),
                    alignment = Alignment.CenterEnd
                )
            }
        }

        Text(
            text = "Payment Summary",
            modifier = Modifier.padding(vertical = 10.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 17.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Price",
                modifier = Modifier.padding(vertical = 10.dp),
                fontSize = 17.sp
            )

            Text(
                text = "$totPrice",
                modifier = Modifier.padding(vertical = 10.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Delivery Fee",
                modifier = Modifier.padding(vertical = 10.dp),
                fontSize = 17.sp
            )

            Text(
                text = "$ $deliveryFee",
                modifier = Modifier.padding(vertical = 10.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )
        }
        HorizontalDivider()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total Payment",
                modifier = Modifier.padding(vertical = 10.dp),
                fontSize = 17.sp
            )

            Text(
                text = "$ $totalPayment",
                modifier = Modifier.padding(vertical = 10.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )
        }
    }
}}

@Composable
fun BootomBB(navController: NavHostController, coffee: CoffeeData, totalPayment: Double, items: Int) {
    Card(colors = CardDefaults.cardColors(Color.White), shape = RoundedCornerShape(30.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 10.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_moneys),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp),
                    colorFilter = ColorFilter.tint(Color(0xfff5b419))
                )

                Text(
                    text = "Cash",
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .background(Color(0xfff5b419))
                        .padding(vertical = 5.dp, horizontal = 10.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 10.sp,
                    color = Color(0xffFFFFFF)
                )


                Image(
                    painter = painterResource(id = R.drawable.ic_dots),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth(),
                    alignment = Alignment.CenterEnd
                )
            }
        }
        Button(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            onClick = { navController.navigate("${Sealed.ThankYou.name}/${coffee.id}/$totalPayment/$items") },
            colors = ButtonDefaults.buttonColors(Color(0xfff5b419)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Order",
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
                fontSize = 18.sp
            )
        }
    }
}