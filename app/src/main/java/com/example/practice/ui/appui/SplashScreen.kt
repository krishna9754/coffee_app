package com.example.practice.ui.appui

import  androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practice.R
import com.example.practice.ui.common.ProgressLoader
import com.example.practice.destination.Sealed
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController) {
    var launched by remember { mutableStateOf(false) }

    LaunchedEffect(launched) {
        if (launched) {
            delay(1500)
            navController.navigate(Sealed.HomeScreen.name) {
                popUpTo(0)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        if (launched) {
            ProgressLoader()
        } else {
            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_coffie),
                    contentDescription = "Coffee Icon",
                    modifier = Modifier.size(250.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Text(
                    text = "Coffee so good, your taste buds will love it.",
                    modifier = Modifier.padding(top = 20.dp),
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "The best grain, the finest roast, the powerful flavor.",
                    modifier = Modifier.padding(top = 20.dp),
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 150.dp, bottom = 45.dp),
                    onClick = { launched = true },
                    colors = ButtonDefaults.buttonColors(Color(0xfff5b419)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Get Started", modifier = Modifier.padding(vertical = 5.dp), color = Color.White)
                }
            }
        }
    }
}


@Preview
@Composable
fun SplashPreview() {
    SplashScreen(navController = NavHostController(LocalContext.current))
}