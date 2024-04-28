package com.example.practice.ui.appui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R


@Composable
fun GoogleMaps() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "10 minutes left",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic
            )
            Text(text = "Delivery to Jl. Kpg Sautoy", fontSize = 12.sp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_delivery_man),
                    contentDescription = "",
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(15.dp)
                        .size(32.dp),
                    colorFilter = ColorFilter.tint(color = Color(0xffC67C4E))
                )

                Column {
                    Text(
                        text = "Delivered your order",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Normal
                    )
                    Text(
                        text = "We deliver your goods to you in the shorts possible time.",
                        modifier = Modifier.width(200.dp),
                        color = Color(0xff808080)
                    )
                }
            }

            Row(
                modifier = Modifier.padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_contactuser),
                        contentDescription = "",
                        modifier = Modifier.size(52.dp)
                    )
                    Column {
                        Text(
                            text = "Johan Han",
                            modifier = Modifier.padding(bottom = 5.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            fontStyle = FontStyle.Normal
                        )
                        Text(
                            text = "Personal Courier",
                            modifier = Modifier.width(200.dp),
                            color = Color(0xff808080)
                        )
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_telpon),
                    contentDescription = "",
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(15.dp)
                        .size(32.dp),
                    colorFilter = ColorFilter.tint(color = Color(0xff808080))
                )
            }
            Divider(Modifier.width(2.dp))
        }
    }
}

@Preview
@Composable
fun MapPreview() {
    GoogleMaps()
}