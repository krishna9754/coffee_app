package com.example.practice.destination

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practice.MVVM.viewModel.CoffeeViewModel
import com.example.practice.ui.appui.AddressScreen
import com.example.practice.ui.appui.Detail
import com.example.practice.ui.appui.HomeScreen
import com.example.practice.ui.appui.Order
import com.example.practice.ui.appui.SplashScreen
import com.example.practice.ui.appui.ThankYou

@Composable
fun CoffeeNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Sealed.SplashScreen.name) {
        composable(Sealed.SplashScreen.name) {
            SplashScreen(navController)
        }

        composable(Sealed.HomeScreen.name) {
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = "${Sealed.Detail.name}/{coffeeId}",
            arguments = listOf(navArgument("coffeeId") { type = NavType.StringType })
        ) { backStackEntry ->
            val coffeeId = backStackEntry.arguments?.getString("coffeeId")
            val viewModel: CoffeeViewModel = hiltViewModel()
            val coffeeItem = viewModel.coffeeState.collectAsState().value.find { it.id == coffeeId }

            if (coffeeItem != null) {
                Detail(
                    coffee = coffeeItem,
                    navController = navController,
                    onBack = { navController.popBackStack() },
                )
            } else {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }


        composable(
            route = "${Sealed.Order.name}/{coffee_id}",
            arguments = listOf(navArgument("coffee_id") { type = NavType.StringType })
        ) { backStackEntry ->
            val coffeeId = backStackEntry.arguments?.getString("coffee_id")
            val viewModel: CoffeeViewModel = hiltViewModel()
            val coffeeItem = viewModel.coffeeState.collectAsState().value.find { it.id == coffeeId }

            if (coffeeItem != null) {
                Order(
                    coffee = coffeeItem,
                    navController = navController,
                    onBack = { navController.popBackStack() }
                )
            } else {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }
        composable(
            route = "${Sealed.Address.name}/{coffee_id}",
            arguments = listOf(navArgument("coffee_id") { type = NavType.StringType })
        ) { backStackEntry ->
            val coffeeId = backStackEntry.arguments?.getString("coffee_id") ?: ""
            AddressScreen(navController = navController, coffeeId = coffeeId)
        }

        composable(Sealed.ThankYou.name) {
            ThankYou(
                onHomeBack = { navController.navigate(Sealed.HomeScreen.name) }
            )
        }
    }
}