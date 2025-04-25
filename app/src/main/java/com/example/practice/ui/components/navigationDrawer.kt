package com.example.practice.ui.components

import androidx.compose.ui.graphics.vector.ImageVector

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