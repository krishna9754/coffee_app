package com.example.practice.ui.appui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice.R
import com.example.practice.di.CoffeeViewModel
import com.example.practice.di.model.dto.CoffeeDto
import com.example.practice.ui.common.ProgressLoader
import com.example.practice.ui.common.ScaffoldBar
import com.example.practice.ui.components.ImageSlider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    scope: CoroutineScope,
    drawerState: DrawerState,
    onNext: () -> Unit,
    viewModel: CoffeeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    if (state.isEmpty()) {
        ProgressLoader()
    } else {
        ScaffoldBar(
            icon = null,
            Icon = false,
            appBarColor = TopAppBarDefaults.topAppBarColors(Color.Transparent),
        ) {
            var text by remember {
                mutableStateOf("")
            }
            Column(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .background(color = Color(0xFF131313))
            ) {}

            Column(
                modifier = Modifier
                    .padding(horizontal = 14.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_user),
                        contentDescription = "",
                        modifier = Modifier
                            .clickable { scope.launch { drawerState.open() } }
                            .size(55.dp)
                    )
                    Text(
                        text = "Location \nBil zen, Kanchenjunga",
                        color = Color(0xffB7B7B7),
                        textAlign = TextAlign.End
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp),
                ) {
                    ImageSlider()
                }

                RowLazy(state)
                Coffee(onNext)
            }
        }
    }
}

@Composable
fun RowLazy(state: List<CoffeeDto>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(state) { index, coffee -> // Use itemsIndexed to get index
            val color = if (index == 0) 0xffC67C4E else 0xffFFFFFF // Index-based color
            val textColor = if (index == 0) 0xffFFFFFF else 0xff151515

            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(Color(color))
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = coffee.title,
                        fontWeight = FontWeight.Bold,
                        color = Color(textColor)
                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun PreviewScreen() {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    HomeScreen(
        scope = scope,
        drawerState = drawerState,
        onNext = { }
    )
}