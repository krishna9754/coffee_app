package com.example.practice.ui.appui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practice.R
import com.example.practice.ui.common.HyperLinkText
import com.example.practice.ui.common.ScaffoldBar
import com.example.practice.ui.data.Sealed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavHostController) = ScaffoldBar(
    Icon = false,
    icon = null,
    title = R.string.sign_Up,
    textColor = Color.White,
    colorEnabled = true,
    appBarColor = TopAppBarDefaults.topAppBarColors(Color(0xffC67C4E))
) {

    val focusManager = LocalFocusManager.current
    var first by remember { mutableStateOf("") }
    var last by remember { mutableStateOf("") }
    var emailid by remember { mutableStateOf("") }
    var mobNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isEnabled = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = first,
                onValueChange = { first = it },
                label = { Text(text = "First", fontSize = 13.sp) },
                shape = RoundedCornerShape(10.dp),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next, keyboardType = KeyboardType.Text
                ),
                maxLines = 1,
                singleLine = true,
                trailingIcon = {
                    if (first.length >= 3) Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "",
                        modifier = Modifier.size(15.dp),
                        tint = Color(0xff008000)
                    )
                }
            )

            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = last,
                onValueChange = { last = it },
                label = { Text(text = "Last (Optional)", fontSize = 13.sp) },
                shape = RoundedCornerShape(10.dp),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next, keyboardType = KeyboardType.Text
                ),
                maxLines = 1,
                singleLine = true,
                trailingIcon = {
                    if (last.length >= 3) Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "",
                        modifier = Modifier.size(15.dp),
                        tint = Color(0xff008000)
                    )
                }
            )
        }

        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = emailid,
            onValueChange = { emailid = it },
            label = { Text(text = "Email", fontSize = 13.sp) },
            shape = RoundedCornerShape(10.dp),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next, keyboardType = KeyboardType.Email
            ),
            trailingIcon = { Text(text = "Optional", modifier = Modifier.padding(end = 10.dp), fontSize = 13.sp)},
            maxLines = 1,
            singleLine = true,
        )

        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mobNumber,
            onValueChange = { mobNumber = it },
            label = { Text(text = "Mob. Number", fontSize = 13.sp) },
            shape = RoundedCornerShape(10.dp),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next, keyboardType = KeyboardType.Number
            ),
            leadingIcon = { Text(text = "+91", color = Color.White) },
            maxLines = 1,
            singleLine = true,
            trailingIcon = {
                if (mobNumber.length == 10) Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "",
                    modifier = Modifier.size(15.dp),
                    tint = Color(0xff008000)
                )
            }
        )

        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password", fontSize = 13.sp) },
            shape = RoundedCornerShape(10.dp),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done, keyboardType = KeyboardType.Password
            ),
            maxLines = 1,
            singleLine = true,
            trailingIcon = {
                if (password.length >= 5) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "",
                        modifier = Modifier.size(15.dp),
                        tint = Color(0xff008000)
                    )
                    isEnabled.value = true
                }
            }
        )

        Spacer(modifier = Modifier.padding(15.dp))

        Button(
            onClick = { navController.navigate(Sealed.LogIn.name) },
            enabled = isEnabled.value,
            colors = ButtonDefaults.buttonColors(Color(0xffC67C4E)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Submit",
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = Color(0xffFFFFFF)
            )
        }

        Text(
            text = "If You already have an Account:- Login",
            modifier = Modifier.clickable { navController.navigate(Sealed.LogIn.name) },
            color = Color.White,
            textDecoration = TextDecoration.Underline
            )

        Divider(
            modifier = Modifier.padding(vertical = 20.dp),
            thickness = 2.dp,
            color = Color(0xffC67C4E)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Divider(modifier = Modifier.weight(1f))
            Text(
                text = "or",
                modifier = Modifier.padding(horizontal = 8.dp),
                fontSize = 20.sp,
                color = Color.White
            )
            Divider(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "",
                    modifier = Modifier.size(35.dp)
                )
                HyperLinkText(
                    fullText = "SignUp with Google",
                    linkText = listOf("Google"),
                    hyperLink = listOf("https://www.google.com"),
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "",
                    modifier = Modifier.size(35.dp)
                )
                HyperLinkText(
                    fullText = "SignUp with Instagram",
                    linkText = listOf("Instagram"),
                    fontSize = 12.5.sp,
                    hyperLink = listOf("https://www.instagram.com/accounts/login/")
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_linkedin),
                    contentDescription = "",
                    modifier = Modifier.size(35.dp)
                )
                HyperLinkText(
                    fullText = "SignUp with LinkDin",
                    linkText = listOf("LinkDin"),
                    hyperLink = listOf("https://in.linkedin.com/?src=go-pa&trk=sem-ga_campid.14650114788_asid.151761418307_crid.657403558721_kw.linkedin%20login_d.c_tid.kwd-12704335873_n.g_mt.e_geo.9298339&mcid=6844056167778418689&cid=&gad_source=1&gclid=CjwKCAjww_iwBhApEiwAuG6ccLFikgNg1H8eIBtDfGQ-SWMHZGgVdqFAzGHPex2hNcyBx2hb4O3E4xoCrnsQAvD_BwE&gclsrc=aw.ds")
                )
            }

        }
    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignUp(navController = NavHostController(LocalContext.current))
}