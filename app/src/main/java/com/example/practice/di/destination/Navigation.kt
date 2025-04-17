package com.example.practice.di.destination

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practice.di.CoffeeViewModel
import com.example.practice.ui.appui.Detail
import com.example.practice.ui.appui.HomeScreen
import com.example.practice.ui.appui.Order
import com.example.practice.ui.appui.SplashScreen
import com.example.practice.ui.appui.ThankYou
//import com.example.practice.ui.components.NavigationDrawer
import com.example.practice.ui.data.Sealed

@Composable
fun CoffeeNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Sealed.SplashScreen.name) {
        composable(Sealed.SplashScreen.name) {
            SplashScreen(navController)
        }
//        composable((Sealed.NavigationDrawer.name)) {
//            NavigationDrawer(navController)
//        }
        composable(Sealed.HomeScreen.name) {
            val scope = rememberCoroutineScope()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            HomeScreen(
                onNext = { navController.navigate(Sealed.Detail.name) },

            )
        }
        composable(Sealed.Detail.name) {
            Detail(
                onNext = { navController.navigate(Sealed.Order.name) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Sealed.Order.name) {
            Order(
                onNext = { navController.navigate(Sealed.ThankYou.name) },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Sealed.ThankYou.name) {
            ThankYou(
                onHomeBack = { navController.navigate(Sealed.HomeScreen.name) }
            )
        }
    }
}