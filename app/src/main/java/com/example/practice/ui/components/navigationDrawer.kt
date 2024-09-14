package com.example.practice.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practice.di.CoffeeViewModel
import com.example.practice.di.repository.CoffeeRepo
import com.example.practice.di.service.CoffeeApiService
import com.example.practice.ui.appui.HomeScreen
import com.example.practice.ui.data.Sealed
import kotlinx.coroutines.launch

//@Composable
//fun NavigationDrawer(navController: NavHostController) {
//
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//    val items = listOf(
//        DrawerItem(label = "Home", secondaryLabel = Icons.Default.Home),
//        DrawerItem(label = "Profile", secondaryLabel = Icons.Default.AccountBox),
//        DrawerItem( label = "Contact Us", secondaryLabel = Icons.Default.Phone),
//        DrawerItem(label = "Help centre", secondaryLabel = Icons.Default.Settings)
//    )
//    val isSelected = remember { mutableStateOf(0) }
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            ModalDrawerSheet(
//                modifier = Modifier.fillMaxWidth().padding(end = 120.dp),
//                drawerContainerColor = Color.Black
//            ) {
//                Row(
//                    modifier = Modifier
//                        .padding(top = 60.dp)
//                        .padding(horizontal = 15.dp)
//                        .fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Text(
//                        text = "Menu",
//                        fontWeight = FontWeight.Bold,
//                        color = Color(0xffC67C4E),
//                        style = MaterialTheme.typography.headlineLarge,
//                    )
//                    Icon(
//                        imageVector = Icons.Filled.Close,
//                        contentDescription = null,
//                        modifier = Modifier
//                            .clickable { scope.launch { drawerState.close() } }
//                            .size(25.dp),
//                        tint = Color.White
//                    )
//                }
//
//                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
//
//                items.forEachIndexed { index, item ->
//                    val textColor = if (isSelected.value == index) Color.White else Color.Black
//                    NavigationDrawerItem(
//                        modifier = Modifier.padding(bottom = 8.dp),
//                        label = { Text(text = item.label, color = textColor) },
//                        selected = isSelected.value == index,
//                        onClick = {isSelected.value = index},
//                        colors = NavigationDrawerItemDefaults.colors(Color(0xffC67C4E)),
//                        icon = { Icon(imageVector = item.secondaryLabel, contentDescription = null) }
//                    )
//                }
//            }
//        },
//        content = {
//            HomeScreen(
//                scope,
//                drawerState
//            ) { navController.navigate(Sealed.Detail.name) }
//        }
//    )
//}


data class DrawerItem(
    val label: String,
    val secondaryLabel: ImageVector
)

//@Preview
//@Composable
//fun PreviewContent() {
//    NavigationDrawer(navController = NavHostController(LocalContext.current))
//}