package org.starlee.rangkulapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.ui.screen.LoginScreen
import org.starlee.rangkulapp.ui.screen.SignupScreen


@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navigateToSignup = { navController.navigate(Screen.Signup.route) })
        }
        composable(Screen.Signup.route) {
            SignupScreen(navigateToLogin = { navController.navigate(Screen.Login.route) })
        }
    }
}