package com.example.practice.destination

enum class Sealed {
    SplashScreen,
    LogIn,
    SignUp,
    NavigationDrawer,
    HomeScreen,
    Detail,
    Order,
    Coffee,
    ThankYou;
    companion object{
        fun fromRoute(route: String?): Sealed
        = when(route?.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            LogIn.name -> LogIn
            SignUp.name -> SignUp
            NavigationDrawer.name -> NavigationDrawer
            HomeScreen.name -> HomeScreen
            Detail.name -> Detail
            Order.name -> Order
            Coffee.name -> Coffee
            ThankYou.name -> ThankYou
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognize")
        }
    }
}