package com.example.practice.ui.appui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practice.MVVM.data.CoffeeData
import com.example.practice.MVVM.viewModel.CoffeeViewModel
import com.example.practice.R
import com.example.practice.destination.Sealed
import com.exyte.animatednavbar.utils.noRippleClickable

@Composable
fun Coffee(
    coffeeList: List<CoffeeData>,
    navController: NavHostController,
    viewModel: CoffeeViewModel,
) {

    val isLoading by viewModel.isLoading.collectAsState()

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(coffeeList) { coffee ->
            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
            ) {
                Column {
                    Image(
                        painter = painterResource(R.drawable.ic_coffieimage),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = coffee.title.ifEmpty { "Cappuccino" },
                        modifier = Modifier.padding(start = 15.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Text(
                        text = coffee.description.ifEmpty { "with Chocolate" },
                        modifier = Modifier.padding(start = 15.dp, bottom = 15.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        maxLines = 2,
                        color = Color(0xff9B9B9B)
                    )

                    Row(
                        modifier = Modifier
                            .padding(start = 15.dp, end = 10.dp, bottom = 10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$ ${coffee.price.toString()}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_plus_icon),
                            contentDescription = "",
                            modifier = Modifier.noRippleClickable {
                                navController.navigate("${Sealed.Detail.name}/${coffee.id}")
                            }
                        )
                    }
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(15.dp))

            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { viewModel.loadNextPage() }
                ) {
                    Text(text = "Load More")
                }
            }
        }
    }
}
