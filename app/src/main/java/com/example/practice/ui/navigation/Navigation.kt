package com.example.practice.ui.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practice.ui.appui.Detail
import com.example.practice.ui.appui.HomeScreen
import com.example.practice.ui.appui.LogIn
import com.example.practice.ui.appui.Order
import com.example.practice.ui.appui.SignUp
import com.example.practice.ui.appui.SplashScreen
import com.example.practice.ui.components.NavigationDrawer
import com.example.practice.ui.data.Sealed

@Composable
fun CoffeeNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Sealed.SplashScreen.name ){
        composable(Sealed.SplashScreen.name){
            SplashScreen(navController)
        }
        composable(Sealed.LogIn.name){
            LogIn(navController)
        }
        composable(Sealed.SignUp.name){
            SignUp(navController)
        }
        composable((Sealed.NavigationDrawer.name)){
            NavigationDrawer(navController)
        }
        composable(Sealed.HomeScreen.name){
            val scope = rememberCoroutineScope()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            HomeScreen(navController, scope = scope, drawerState = drawerState)
        }
        composable(Sealed.Detail.name){
            Detail(navController) { navController.navigate(Sealed.HomeScreen.name) }
        }
        composable(Sealed.Order.name){
            Order(navController) { navController.navigate(Sealed.Detail.name) }
        }
    }
}