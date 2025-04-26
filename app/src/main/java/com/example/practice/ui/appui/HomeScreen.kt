package com.example.practice.ui.appui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.practice.MVVM.data.CoffeeData
import com.example.practice.MVVM.viewModel.CoffeeViewModel
import com.example.practice.R
import com.example.practice.ui.common.ProgressLoader
import com.example.practice.ui.common.ScaffoldBar
import com.example.practice.ui.components.ImageSlider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
//    onNext: () -> Unit,
    viewModel: CoffeeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val coffeeList by viewModel.coffeeState.collectAsState()
    val error by viewModel.error.collectAsState()

    when {
        error != null -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = error ?: "Unknown error",
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        coffeeList.isEmpty() -> {
            ProgressLoader()
        }

        else -> {
            ScaffoldBar(
                icon = R.drawable.ic_user,
                Icon = R.drawable.ic_hamburger,
                appBarColor = TopAppBarDefaults.topAppBarColors(Color(0xffC67C4E)),
            ) {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Column(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth()
                            .height(210.dp)
                            .background(color = Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        ImageSlider()
                    }

                    RowLazy(coffeeList)
                    HorizontalDivider(modifier = Modifier.padding(top = 10.dp))
                    Coffee(navController = navController, coffeeList = coffeeList)
                }
            }
        }
    }
}


@Composable
fun RowLazy(coffeeData: List<CoffeeData>) {
    Text(
        text = "Note:- Only View Item",
        modifier = Modifier.padding(start = 14.dp, bottom = 10.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.Red
    )
    LazyRow(
        modifier = Modifier.padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(coffeeData) { index, data ->
            val color = if (index == 0) 0xffC67C4E else 0xffFFFFFF
            val textColor = if (index == 0) 0xffFFFFFF else 0xff151515

            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(Color(color))
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    data.roaster?.let {
                        Text(
                            text = it,
                            fontWeight = FontWeight.Bold,
                            color = Color(textColor)
                        )
                    }
                }
            }
        }
    }
}