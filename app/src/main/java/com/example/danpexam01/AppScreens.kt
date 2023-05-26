package com.example.danpexam01

sealed class AppScreens (
    val route: String
) {
    object LoginScreen: AppScreens("login_screen")
    object HomeScreen: AppScreens("home_screen")
    object RegisterScreen: AppScreens("register_screen")
    object HacerCita: AppScreens("hacerCita_screen")
    object DetailScreen: AppScreens("detail_screen/{id}")
}

