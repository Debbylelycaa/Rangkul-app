package org.starlee.rangkulapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.ui.screen.BerandaScreen
import org.starlee.rangkulapp.ui.screen.DetailPembayaranScreen
import org.starlee.rangkulapp.ui.screen.DonasiScreen
import org.starlee.rangkulapp.ui.screen.InfoPenggalanganDanaScreen
import org.starlee.rangkulapp.ui.screen.MulaiDonasiScreen
import org.starlee.rangkulapp.ui.screen.PembayaranBerhasilScreen
import org.starlee.rangkulapp.ui.screen.RangkulAsaScreen
import org.starlee.rangkulapp.ui.screen.TerimakasihScreen
import org.starlee.rangkulapp.ui.screen.TransferScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Home.route){
            BerandaScreen(navController)
        }
        composable(route = Screen.DetailPembayaran.route){
            DetailPembayaranScreen(navController)
        }
        composable(route = Screen.MulaiDonasi.route){
            MulaiDonasiScreen(navController)
        }
        composable(route = Screen.PembayaranBerhasil.route){
            PembayaranBerhasilScreen(navController)
        }
        composable(route = Screen.Terimakasih.route){
            TerimakasihScreen(navController)
        }
        composable(route = Screen.Transfer.route){
            TransferScreen(navController)
        }
        composable(route = Screen.InfoPenggalanganDana.route){
            InfoPenggalanganDanaScreen(navController)
        }
        composable(route = Screen.Donasi.route){
            DonasiScreen(navController)
        }
        composable(route = Screen.RangkulAsa.route){
            RangkulAsaScreen(navController)
        }
    }
}