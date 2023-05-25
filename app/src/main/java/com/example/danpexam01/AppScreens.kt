package com.example.danpexam01

sealed class AppScreens (
    val route: String
) {
    object LoginScreen: AppScreens("login_screen")
    object HomeScreen: AppScreens("home_screen")
}
