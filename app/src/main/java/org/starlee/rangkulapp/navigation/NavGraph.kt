package org.starlee.rangkulapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import  org.starlee.rangkulapp.ui.screen.BerandaScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()){
    NavHost(navController = navController, startDestination = Screen.Home.route ){
        composable(route = Screen.Home.route){
            BerandaScreen()
        }
    }
}