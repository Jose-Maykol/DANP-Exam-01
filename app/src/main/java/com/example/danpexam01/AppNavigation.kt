package com.example.danpexam01

import HacerCita
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.danpexam01.screens.DetailScreen
import com.example.danpexam01.screens.HomeScreen
import com.example.danpexam01.screens.LoginScreen
import com.example.danpexam01.screens.RegisterScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.LoginScreen.route
    ) {
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(AppScreens.HacerCita.route) {
            HacerCita(navController = navController)
        }
        composable(AppScreens.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(AppScreens.DetailScreen.route) {
            val id = it.arguments?.getString("id")
            DetailScreen(navController = navController, id = id!!.toInt())
        }
    }
}

