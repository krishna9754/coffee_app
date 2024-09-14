package com.example.practice.ui.appui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.common.ScaffoldBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Order(onNext: () -> Unit, onBack: () -> Boolean) = ScaffoldBar(
    title = R.string.order,
    Icon = false,
    onBack = { onBack.invoke() },
    bottomBar = { BootomBB(onNext) },
    appBarColor = TopAppBarDefaults.topAppBarColors(Color.Transparent)
) {

    val editableText = remember { mutableStateOf("") }
    var savedAddress by remember { mutableStateOf("") } // Add state to store the saved address
    var saved by remember { mutableStateOf(true) }
    var items by remember {
        mutableStateOf(1)
    }

    val colorz = remember {
        mutableStateOf(false)
    }

    val text = if (!colorz.value) "Delivery" else "Pick Up"

    Column(
        modifier = Modifier
            .padding(it)
            .padding(horizontal = 25.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .background(color = Color(0xFFF2F2F2), shape = RoundedCornerShape(15.dp))
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 10.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = { if (colorz.value) colorz.value = false },
                colors = ButtonDefaults.buttonColors(Color(if (colorz.value) 0xffF2F2F2 else 0xffC67C4E)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Delivery", color = Color(if (colorz.value) 0xff2F2D2C else 0xffFFFFFF))
            }
            Spacer(modifier = Modifier.padding(12.dp))
            Button(
                onClick = { if (!colorz.value) colorz.value = true },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(Color(if (!colorz.value) 0xffF2F2F2 else 0xffC67C4E)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Pick Up", color = Color(if (!colorz.value) 0xff2F2D2C else 0xffFFFFFF))
            }
        }

        Text(
            text = "$text Address",
            modifier = Modifier.padding(top = 20.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        if (saved) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = editableText.value,
                onValueChange = {
                    editableText.value = it
                },
                placeholder = { Text(text = "Enter Your Address", color = Color.LightGray) },
                minLines = 5,
                keyboardActions = KeyboardActions.Default,
            )
        }

        Row(
            modifier = Modifier.padding(top = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Edit Address",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .clickable { saved = !saved }
                    .border(BorderStroke(1.dp, Color.LightGray), shape = RoundedCornerShape(20.dp))
                    .padding(vertical = 6.dp, horizontal = 15.dp),
                fontSize = 13.sp,
            )
            if (saved) {
                Text(
                    text = "Save",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .clickable {
                            savedAddress =
                                editableText.value // Save the address when the button is clicked
                            saved = !saved
                        }
                        .border(
                            BorderStroke(1.dp, Color.LightGray),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(vertical = 6.dp, horizontal = 15.dp),
                    fontSize = 13.sp,
                )
            }
        }

        // Display the saved address
        if (savedAddress.isNotEmpty()) {
            Text(
                text = "Saved Address: $savedAddress",
                modifier = Modifier.padding(top = 10.dp),
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Divider(modifier = Modifier.padding(top = 20.dp))
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
                Image(painter = painterResource(id = R.drawable.coffie), contentDescription = "")
                Text(
                    text = "Cappuccino\nwith Chocolate",
                    fontSize = 15.sp
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_subtract),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { if (items >= 2) items = items - 1 },
                )
                Text(
                    text = "$items",
                    fontSize = 20.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { items = items + 1 }
                )
            }

        }

        Divider(modifier = Modifier.padding(top = 20.dp), thickness = 4.dp)

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

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Price",
                modifier = Modifier.padding(vertical = 10.dp),
                fontSize = 17.sp
            )

            Text(
                text = "$ 4.53",
                modifier = Modifier.padding(vertical = 10.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Delivery Fee",
                modifier = Modifier.padding(vertical = 10.dp),
                fontSize = 17.sp
            )

            Text(
                text = "$ 1.0",
                modifier = Modifier.padding(vertical = 10.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )
        }
        Divider()
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Total Payment",
                modifier = Modifier.padding(vertical = 10.dp),
                fontSize = 17.sp
            )

            Text(
                text = "$ 5.53",
                modifier = Modifier.padding(vertical = 10.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )
        }
    }
}

@Composable
fun BootomBB(onNext: () -> Unit) {
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
                )

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xffF2F2F2)),
                ) {
                    Text(
                        text = "Cash",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(10.dp)
                            )
                            .background(Color(0xffC67C4E))
                            .padding(vertical = 5.dp, horizontal = 10.dp),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp,
                        color = Color(0xffFFFFFF)
                    )
                    Text(
                        text = "\$ 5.53",
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp
                    )
                }

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
            onClick = { onNext.invoke() },
            colors = ButtonDefaults.buttonColors(Color(0xffC67C4E)),
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


//@Preview
//@Composable
//fun OrderPrev() {
//    Order(navController = NavHostController(LocalContext.current), onBack = {})
//}