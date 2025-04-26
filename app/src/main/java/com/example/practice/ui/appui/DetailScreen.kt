package com.example.practice.ui.appui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practice.MVVM.data.CoffeeData
import com.example.practice.R
import com.example.practice.destination.Sealed
import com.example.practice.ui.common.ScaffoldBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detail(
    onBack: () -> Boolean,
    coffee: CoffeeData,
    navController: NavHostController
) = ScaffoldBar(
    title = R.string.detail,
    onBack = { onBack.invoke() },
    bottomBar = { PriceTag(navController, coffee) }
) {

    LazyColumn(
        modifier = Modifier
            .padding(it)
            .padding(horizontal = 20.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.ic_offer_banner),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(20.dp)
                    ),
                contentDescription = "",
            )

            Text(
                text = coffee.title,
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp
            )
            Text(
                text = coffee.description,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = Color(0xff9B9B9B)
            )

            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "",
                        tint = Color(0xffFBBE21)
                    )
                    coffee.rating?.let { it1 -> Text(text = "${it1}/100", fontSize = 15.sp) }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_coffee_been),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xffC67C4E)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_milk),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xffC67C4E)
                    )
                }
            }
            HorizontalDivider(modifier = Modifier.padding(top = 15.dp))

            Text(
                text = "Description",
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp
            )

            Text(
                text = coffee.description2,
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = Color(0xff9B9B9B)
            )

            Text(
                text = "Variant",
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Column(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xffC67C4E),
                        shape = RoundedCornerShape(14.dp)
                    )
                    .padding(vertical = 15.dp, horizontal = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = coffee.roast,
                    color = Color(0xffC67C4E),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Composable
fun PriceTag(navController: NavHostController, coffee: CoffeeData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = "Price", fontSize = 15.sp, color = Color(0xff9B9B9B))
            coffee.price?.let { Text(text = "$${it}", fontSize = 25.sp, color = Color(0xffC67C4E)) }
        }

        Button(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            onClick = { navController.navigate("${Sealed.Order.name}/${coffee.id}") },
            colors = ButtonDefaults.buttonColors(Color(0xffC67C4E)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Buy Now", modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp))
        }
    }
}