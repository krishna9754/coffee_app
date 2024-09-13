//package com.example.practice.ui.appui
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountBox
//import androidx.compose.material.icons.filled.CheckCircle
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.Icon
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalFocusManager
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextDecoration
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import com.airbnb.lottie.compose.LottieAnimation
//import com.airbnb.lottie.compose.LottieCompositionSpec
//import com.airbnb.lottie.compose.rememberLottieComposition
//import com.example.practice.R
//import com.example.practice.ui.common.HyperLinkText
//import com.example.practice.ui.common.ProgressLoader
//import com.example.practice.ui.common.ScaffoldBar
//import com.example.practice.ui.data.Sealed
//import kotlinx.coroutines.delay
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LogIn(navController: NavHostController) = ScaffoldBar(
//    Icon = false,
//    icon = null,
//    title = R.string.log_in,
//    textColor = Color.White,
//    colorEnabled = true,
//    appBarColor = TopAppBarDefaults.topAppBarColors(Color(0xffC67C4E))
//) {
//
//    var text by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var pin by remember { mutableStateOf("") }
//    val colorz = remember { mutableStateOf(false) }
//    val focusManager = LocalFocusManager.current
//    val isEnabled = remember { mutableStateOf(false) }
//    val timer = remember { mutableStateOf(false) }
//
//    if (timer.value) {
//        ProgressLoader()
//        LaunchedEffect(Unit) {
//            delay(3000)
//            navController.navigate(Sealed.NavigationDrawer.name)
//        }
//    } else {
//
//        Column(
//            modifier = Modifier
//                .padding(it)
//                .padding(horizontal = 20.dp, vertical = 20.dp)
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState()),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Row(
//                modifier = Modifier
//                    .border(
//                        width = 2.dp,
//                        color = Color(0xffC67C4E),
//                        shape = RoundedCornerShape(15.dp)
//                    )
//                    .background(color = Color(0xFFF2F2F2), shape = RoundedCornerShape(15.dp))
//                    .fillMaxWidth()
//                    .padding(vertical = 10.dp, horizontal = 10.dp)
//            ) {
//                Button(
//                    onClick = { if (colorz.value) colorz.value = false },
//                    colors = ButtonDefaults.buttonColors(Color(if (colorz.value) 0xffF2F2F2 else 0xffC67C4E)),
//                    shape = RoundedCornerShape(10.dp)
//                ) {
//                    Text(
//                        text = "Login With Password",
//                        color = Color(if (colorz.value) 0xff2F2D2C else 0xffFFFFFF)
//                    )
//                }
//                Spacer(modifier = Modifier.padding(2.dp))
//                Button(
//                    onClick = { if (!colorz.value) colorz.value = true },
//                    colors = ButtonDefaults.buttonColors(Color(if (!colorz.value) 0xffF2F2F2 else 0xffC67C4E)),
//                    shape = RoundedCornerShape(10.dp)
//                ) {
//                    Text(
//                        text = "Login With OTP",
//                        color = Color(if (!colorz.value) 0xff2F2D2C else 0xffFFFFFF)
//                    )
//                }
//            }
//
//            HorizontalDivider(
//                modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
//                thickness = 2.dp,
//                color = Color(0xffC67C4E)
//            )
//
//            LottieFiles()
//
//            OutlinedTextField(
//                modifier = Modifier.fillMaxWidth(),
//                value = text,
//                onValueChange = {texts -> text = texts },
//                label = { Text(text = "Enter Number", color = Color.White) },
//                shape = RoundedCornerShape(10.dp),
//                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    imeAction = ImeAction.Next, keyboardType = KeyboardType.Phone
//                ),
//                maxLines = 1,
//                singleLine = true,
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.AccountBox,
//                        contentDescription = "", tint = Color.White
//                    )
//                },
//                trailingIcon = {
//                    if (text.length == 10) Icon(
//                        imageVector = Icons.Default.CheckCircle,
//                        contentDescription = "",
//                        modifier = Modifier.size(20.dp),
//                        tint = Color(0xff008000)
//                    )
//                },
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color(0xffC67C4E),
//                    unfocusedBorderColor = Color.LightGray,
//                    focusedTextColor = Color.White,
//                    unfocusedTextColor = Color.White,
//                ),
//            )
//
//            isEnabled.value = text.length >= 3 && password.length >= 6 || pin.length == 1
//
//            if (!colorz.value) {
//
//                OutlinedTextField(
//                    modifier = Modifier.fillMaxWidth(),
//                    value = password,
//                    onValueChange = {passwords -> password = passwords },
//                    label = { Text(text = "Password", color = Color.White) },
//                    keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
//                    keyboardOptions = KeyboardOptions.Default.copy(
//                        imeAction = ImeAction.Done, keyboardType = KeyboardType.Password
//                    ),
//                    shape = RoundedCornerShape(10.dp),
//                    maxLines = 1,
//                    singleLine = true,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedBorderColor = Color(0xffC67C4E),
//                        unfocusedBorderColor = Color.LightGray,
//                        focusedTextColor = Color.White,
//                        unfocusedTextColor = Color.White,
//                    )
//                )
//                Spacer(modifier = Modifier.padding(bottom = 20.dp))
//            } else {
//
//                Box {
//                    Row(
//                        modifier = Modifier.padding(vertical = 20.dp),
//                        horizontalArrangement = Arrangement.spacedBy(20.dp)
//                    ) {
//                        repeat(4) {
//                            OutlinedTextField(
//                                modifier = Modifier
//                                    .padding(start = 10.dp)
//                                    .size(58.dp),
//                                value = pin,
//                                onValueChange = {pins -> pin = pins },
//                                singleLine = true,
//                                placeholder = {
//                                    Text(
//                                        text = "*",
//                                        modifier = Modifier.fillMaxWidth(),
//                                        fontSize = 20.sp,
//                                        textAlign = TextAlign.Center
//                                    )
//                                },
//                                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
//                                keyboardOptions = KeyboardOptions.Default.copy(
//                                    imeAction = ImeAction.Done,
//                                    keyboardType = KeyboardType.NumberPassword
//                                ),
//                                colors = TextFieldDefaults.outlinedTextFieldColors(
//                                    focusedBorderColor = Color(0xffC67C4E),
//                                    unfocusedBorderColor = Color.LightGray,
//                                    focusedTextColor = Color.White,
//                                    unfocusedTextColor = Color.White
//                                ),
//                                shape = RoundedCornerShape(10.dp),
//                                textStyle = TextStyle(textAlign = TextAlign.Center)
//                            )
//                        }
//                    }
//                }
//            }
//
//            Button(
//                onClick = { timer.value = true },
//                enabled = isEnabled.value,
//                colors = ButtonDefaults.buttonColors(Color(0xffC67C4E)),
//                shape = RoundedCornerShape(10.dp)
//            ) {
//                Text(
//                    text = "Submit",
//                    modifier = Modifier
//                        .padding(vertical = 8.dp)
//                        .fillMaxWidth(),
//                    textAlign = TextAlign.Center,
//                    fontSize = 15.sp,
//                    color = Color(0xffFFFFFF)
//                )
//            }
//
//            Spacer(modifier = Modifier.padding(5.dp))
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "forget password",
//                    modifier = Modifier.clickable { },
//                    color = Color.White,
//                    textDecoration = TextDecoration.Underline
//                )
//                Text(
//                    text = "Sign-Up",
//                    modifier = Modifier.clickable { navController.navigate(Sealed.SignUp.name) },
//                    color = Color.White,
//                    textDecoration = TextDecoration.Underline
//                )
//
//            }
//
//            HorizontalDivider(
//                modifier = Modifier.padding(top = 20.dp),
//                thickness = 2.dp,
//                color = Color(0xffC67C4E)
//            )
//
//            Spacer(modifier = Modifier.padding(10.dp))
//
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(10.dp)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_google),
//                        contentDescription = "",
//                        modifier = Modifier.size(35.dp)
//                    )
//                    HyperLinkText(
//                        fullText = "LogIn with Google",
//                        linkText = listOf("Google"),
//                        hyperLink = listOf("https://www.google.com"),
//                    )
//                }
//
//                Spacer(modifier = Modifier.padding(10.dp))
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(10.dp)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_instagram),
//                        contentDescription = "",
//                        modifier = Modifier.size(35.dp)
//                    )
//                    HyperLinkText(
//                        fullText = "LogIn with Instagram",
//                        linkText = listOf("Instagram"),
//                        fontSize = 12.5.sp,
//                        hyperLink = listOf("https://www.instagram.com/accounts/login/")
//                    )
//                }
//
//                Spacer(modifier = Modifier.padding(10.dp))
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(10.dp)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_linkedin),
//                        contentDescription = "",
//                        modifier = Modifier.size(35.dp)
//                    )
//                    HyperLinkText(
//                        fullText = "LogIn with LinkDin",
//                        linkText = listOf("LinkDin"),
//                        hyperLink = listOf("https://in.linkedin.com/?src=go-pa&trk=sem-ga_campid.14650114788_asid.151761418307_crid.657403558721_kw.linkedin%20login_d.c_tid.kwd-12704335873_n.g_mt.e_geo.9298339&mcid=6844056167778418689&cid=&gad_source=1&gclid=CjwKCAjww_iwBhApEiwAuG6ccLFikgNg1H8eIBtDfGQ-SWMHZGgVdqFAzGHPex2hNcyBx2hb4O3E4xoCrnsQAvD_BwE&gclsrc=aw.ds")
//                    )
//                }
//
//            }
//        }
//    }
//}
//
//
//@Composable
//private fun LottieFiles() {
//    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottecoffee))
//
//    LottieAnimation(
//        composition = composition,
//        modifier = Modifier.size(200.dp)
//    )
//}
//
//
//@Preview
//@Composable
//fun PreviewLogIn() {
//    LogIn(navController = NavHostController(LocalContext.current))
//}