package com.example.zh_matuale.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zh_matuale.screens.HomeScreen
import com.example.zh_matuale.screens.LogScreen
import com.example.zh_matuale.screens.NotionScreen
import com.example.zh_matuale.screens.OTPScreen
import com.example.zh_matuale.screens.OnboardScreen
import com.example.zh_matuale.screens.PolicyScreen
import com.example.zh_matuale.screens.SplashScreen
import com.example.zh_matuale.screens.PopularScreen
import com.example.zh_matuale.screens.ProfileScreen
import com.example.zh_matuale.screens.RecoverScreen
import com.example.zh_matuale.screens.ShopkartScreen
import com.example.zh_matuale.screens.SigninScreen


sealed class NavRoute (val route: String) {
    object Log: NavRoute("log_screen")
    object Home: NavRoute("home_screen")
    object Splash: NavRoute("splash_screen")
    object Onboard: NavRoute("onboard_screen")
    object Popular: NavRoute("popular_screen")
    object Favorite: NavRoute("favorite_screen")
    object Shopkart: NavRoute("shopkart_screen")
    object SigninScreen: NavRoute("signin_screen")
    object Recover: NavRoute("recover_screen")
    object PolicyScreen: NavRoute("policy_screen")
    object OTPScreen: NavRoute("policy_screen")
    object ProfileScreen: NavRoute("profile_screen")
    object NotionScreen: NavRoute("notion_screen")
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
        composable(NavRoute.Shopkart.route){ ShopkartScreen(navController) }
        composable(NavRoute.SigninScreen.route){ SigninScreen(navController) }
        composable(NavRoute.Recover.route){ RecoverScreen(navController) }
        composable(NavRoute.PolicyScreen.route){ PolicyScreen(navController) }
        composable(NavRoute.OTPScreen.route){ OTPScreen(navController) }
        composable(NavRoute.ProfileScreen.route){ ProfileScreen(navController) }
        composable(NavRoute.NotionScreen.route){ NotionScreen(navController) }
    }
}