package org.starlee.rangkulapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.starlee.rangkulapp.ui.screen.AboutScreen
import org.starlee.rangkulapp.ui.screen.BerandaScreen
import org.starlee.rangkulapp.ui.screen.DetailDonasiScreen
import org.starlee.rangkulapp.ui.screen.DetailPembayaranScreen
import org.starlee.rangkulapp.ui.screen.DetailRangkulPeduliScreen
import org.starlee.rangkulapp.ui.screen.DonasiScreen
import org.starlee.rangkulapp.ui.screen.EditProfilScreen
import org.starlee.rangkulapp.ui.screen.EmailScreen
import org.starlee.rangkulapp.ui.screen.GantiKataSandiScreen
import org.starlee.rangkulapp.ui.screen.InfoPenggalanganDanaScreen
import org.starlee.rangkulapp.ui.screen.MulaiDonasiScreen
import org.starlee.rangkulapp.ui.screen.PembayaranBerhasilScreen
import org.starlee.rangkulapp.ui.screen.ProfilScreen
import org.starlee.rangkulapp.ui.screen.RangkulAsaScreen
import org.starlee.rangkulapp.ui.screen.RangkulPeduliScreen
import org.starlee.rangkulapp.ui.screen.TerimakasihScreen
import org.starlee.rangkulapp.ui.screen.TransferScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            BerandaScreen(navController)
        }
        composable(route = Screen.DetailPembayaran.route) {
            DetailPembayaranScreen(navController)
        }
        composable(route = Screen.MulaiDonasi.route) {
            MulaiDonasiScreen(navController)
        }
        composable(route = Screen.PembayaranBerhasil.route) {
            PembayaranBerhasilScreen(navController)
        }
        composable(route = Screen.Terimakasih.route) {
            TerimakasihScreen(navController)
        }
        composable(route = Screen.Transfer.route) {
            TransferScreen(navController)
        }
        composable(route = Screen.InfoPenggalanganDana.route) {
            InfoPenggalanganDanaScreen(navController)
        }
        composable(route = Screen.Donasi.route) {
            DonasiScreen(navController)
        }
        composable(route = Screen.RangkulAsa.route) {
            RangkulAsaScreen(navController)
        }
        composable(route = Screen.DetailDonasi.route) {
            DetailDonasiScreen(navController)
        }
        composable(route = Screen.RangkulPeduli.route) {
            RangkulPeduliScreen(navController)
        }
        composable(route = Screen.RangkulAsa.route) {
            RangkulAsaScreen(navController)
        }
        composable(route = Screen.DetailRangkulPeduli.route) {
            DetailRangkulPeduliScreen(navController)
        }
        composable(route = Screen.GantiKataSandi.route) {
            GantiKataSandiScreen(navController)
        }

        composable(route = Screen.Email.route) {
            EmailScreen(navController)
        }
                composable(route = Screen.About.route) {
                    AboutScreen(navController)
                }
        composable(route = Screen.EditProfil.route) {
            EditProfilScreen(navController)
        }
        composable(route = Screen.Profil.route) {
            ProfilScreen(navController)
        }


    }
}
