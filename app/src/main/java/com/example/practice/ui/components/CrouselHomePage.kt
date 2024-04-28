package com.example.practice.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselItem() {
    val coffeeList = listOf(
        R.drawable.ic_coffe_1,
        R.drawable.ic_cofee_2,
        R.drawable.ic_coffee_3,
        R.drawable.ic_coffee_4,
    )

    Carousel(coffeeList)
}

@Composable
fun Carousel(coffeeList: List<Int>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(200.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        items(coffeeList) { coffee ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .width(150.dp)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                // You can put your item content here
                Image(painter = painterResource(id = coffee), contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
private fun CarouselPreview() {
    CarouselItem()
}