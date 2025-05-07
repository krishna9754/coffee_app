package com.example.practice.ui.appui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.practice.MVVM.data.CoffeeData
import com.example.practice.R

@Composable
fun ThankYou(onHomeBack: () -> Unit, coffeeId: CoffeeData?, totalPayment: Double, items: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CompleteLoader()
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Thank You For Order with us!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Here are the details",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(30.dp))
        SeperateRow("Name", "User Name")
        Spacer(modifier = Modifier.height(15.dp))
        SeperateRow("Total Item", "$items")
        Spacer(modifier = Modifier.height(15.dp))
        SeperateRow("Item", coffeeId?.title ?: "")
        Spacer(modifier = Modifier.height(15.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(15.dp))
        SeperateRow(
            "Payment",
            "$${"%.2f".format(totalPayment)}",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onHomeBack.invoke() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xfff5b419))
        ) {
            Text(text = "Go to Home")
        }
    }
}

@Composable
fun SeperateRow(
    item: String,
    item1: String,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 14.sp
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item, fontSize = fontSize, fontWeight = fontWeight)
        Text(text = item1, fontSize = fontSize, fontWeight = fontWeight)
    }
}

@Composable
private fun CompleteLoader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.complete))

        LottieAnimation(
            composition = composition,
            modifier = Modifier.size(250.dp),
            iterations = LottieConstants.IterateForever,
            isPlaying = true,
            restartOnPlay = true
        )
    }
}