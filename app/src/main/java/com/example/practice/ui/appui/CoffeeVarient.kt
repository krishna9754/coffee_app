package com.example.practice.ui.appui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practice.R
import com.example.practice.ui.data.Sealed

@Composable
fun Coffee(onNext: () -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(10) {
            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_coffieimage),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(10.dp)
                        .border(width = 0.dp, color = Color.LightGray, shape = RoundedCornerShape(10.dp))
                )
                Text(
                    text = "Cappuccino",
                    modifier = Modifier.padding(start = 15.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "with Chocolate",
                    modifier = Modifier.padding(start = 15.dp, bottom = 15.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xff9B9B9B)
                )

                Row(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 10.dp, bottom = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "$ 4.53", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Image(
                        painter = painterResource(id = R.drawable.ic_plus_icon),
                        contentDescription = "",
                        modifier = Modifier.clickable { onNext.invoke() }
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun PreviewCoffee() {
    Coffee( onNext = {} )
}