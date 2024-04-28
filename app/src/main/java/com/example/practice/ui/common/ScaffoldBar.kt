package com.example.practice.ui.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldBar(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
    @StringRes title: Int? = null ,
    @DrawableRes icon: Int? = R.drawable.ic_arrow___left_2,
    Icon: Boolean = true,
    bottomBar: @Composable () -> Unit = {},
    textColor: Color = Color(0xff2F2D2C),
    colorEnabled: Boolean = false,
    containerColor: Color = MaterialTheme.colorScheme.background,
    appBarColor: TopAppBarColors = TopAppBarDefaults.topAppBarColors(Color(0xffFFFFFF)),
    content: @Composable (PaddingValues) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = appBarColor,
                title = {
                    Row(
                        modifier = modifier.fillMaxWidth().padding(end = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (icon != null) {
                        IconButton(onClick = onBack) {
                            Icon(
                                painter = painterResource(id = icon),
                                contentDescription = "Menu",
                                tint = Color(0xff8D8D8D)
                            )
                        }
                    }
                        if (title != null) {
                            Text(
                                text = stringResource(id = title),
                                modifier = modifier.fillMaxWidth(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 23.sp,
                                color = textColor,
                                textAlign = TextAlign.Center
                            )
                        }

                        if (Icon == true) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_top_heart),
                                contentDescription = "",
                                tint = Color(0xff2F2D2C)
                            )
                        }
                    }
                },
            )
        },

        containerColor = containerColor,
        bottomBar = bottomBar
    ) { inner ->

        val brush = Brush.linearGradient(listOf(Color(0xff292927), Color(0xFF4f4f4d )))
        val whiteBrush = Brush.horizontalGradient(listOf(Color(0xffF9F9F9), Color(0xffF9F9F9)))

        val backgroundColor = if (colorEnabled) brush else whiteBrush

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = backgroundColor)
        ) {
            content(inner)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewScaf() {
    ScaffoldBar()
}