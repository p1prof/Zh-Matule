package com.example.zh_matuale.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zh_matuale.screens.HomeScreen
import com.example.zh_matuale.screens.LogScreen
import com.example.zh_matuale.screens.OnboardScreen
import com.example.zh_matuale.screens.SplashScreen
import com.example.zh_matuale.screens.PopularScreen


sealed class NavRoute (val route: String) {
    object Log: NavRoute("log_screen")
    object Home: NavRoute("home_screen")
    object Splash: NavRoute("splash_screen")
    object Onboard: NavRoute("onboard_screen")
    object Popular: NavRoute("popular_screen")
    object Favorite: NavRoute("favorite_screen")
    object Shopkart: NavRoute("favorite_screen")
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

   NavHost(navController, startDestination = NavRoute.Log.route) {
        composable(NavRoute.Log.route){ LogScreen(navController)}
        composable(NavRoute.Home.route){ HomeScreen(navController)}
        composable(NavRoute.Splash.route){ SplashScreen(navController) }
        composable(NavRoute.Onboard.route){ OnboardScreen(navController, onFinish = {navController.navigate(NavRoute.Home.route)}) }
       composable(NavRoute.Popular.route){ PopularScreen(navController) }
    }
}