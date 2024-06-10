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
import org.starlee.rangkulapp.ui.screen.DetailRangkulPeduliScreen1
import org.starlee.rangkulapp.ui.screen.EditProfilScreen
import org.starlee.rangkulapp.ui.screen.EmailScreen
import org.starlee.rangkulapp.ui.screen.ForgotPasswordScreen
import org.starlee.rangkulapp.ui.screen.GantiKataSandiScreen
import org.starlee.rangkulapp.ui.screen.InfoPenggalanganDanaScreen
import org.starlee.rangkulapp.ui.screen.LoginScreen
import org.starlee.rangkulapp.ui.screen.MulaiDonasiScreen
import org.starlee.rangkulapp.ui.screen.PembayaranBerhasilScreen
import org.starlee.rangkulapp.ui.screen.ProfilScreen
import org.starlee.rangkulapp.ui.screen.RangkulAsaScreen
import org.starlee.rangkulapp.ui.screen.RangkulPeduliScreen
import org.starlee.rangkulapp.ui.screen.RencanaPenggunaanDana
import org.starlee.rangkulapp.ui.screen.SignupScreen
import org.starlee.rangkulapp.ui.screen.TerimakasihScreen
import org.starlee.rangkulapp.ui.screen.TransferScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Login.route) {
        composable(route = BottomBarScreen.Donasi.route) {
            BerandaScreen(navController)
        }
        composable(route = Screen.Home.route) {
            BerandaScreen(navController)
        }
        composable(route = BottomBarScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = BottomBarScreen.SignUp.route) {
            SignupScreen(navController)
        }
        composable(route = BottomBarScreen.RangkulPeduli.route) {
            RangkulPeduliScreen(navController)
        }
        composable(route = BottomBarScreen.Profil.route) {
            ProfilScreen(navController)
        }
        composable(route = BottomBarScreen.DetailPembayaran.route) {
            DetailPembayaranScreen(navController)
        }
        composable(route = BottomBarScreen.MulaiDonasi.route) {
            MulaiDonasiScreen(navController)
        }
        composable(route = BottomBarScreen.PembayaranBerhasil.route) {
            PembayaranBerhasilScreen(navController)
        }
        composable(route = BottomBarScreen.Terimakasih.route) {
            TerimakasihScreen(navController)
        }
        composable(route = BottomBarScreen.Transfer.route) {
            TransferScreen(navController)
        }
        composable(route = BottomBarScreen.InfoPenggalanganDana.route) {
            InfoPenggalanganDanaScreen(navController)
        }
        composable(route = BottomBarScreen.RangkulAsa.route) {
            RangkulAsaScreen(navController)
        }
        composable(route = BottomBarScreen.DetailDonasi.route) {
            DetailDonasiScreen(navController)
        }
        composable(route = BottomBarScreen.RangkulAsa.route) {
            RangkulAsaScreen(navController)
        }
        composable(route = BottomBarScreen.DetailRangkulPeduli.route) {
            DetailRangkulPeduliScreen(navController)
        }
        composable(route = BottomBarScreen.DetailRangkulPeduli1.route) {
            DetailRangkulPeduliScreen1(navController)
        }
        composable(route = BottomBarScreen.EditProfil.route) {
            EditProfilScreen(navController)
        }
        composable(route = BottomBarScreen.Email.route) {
            EmailScreen(navController)
        }
        composable(route = BottomBarScreen.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }
        composable(route = BottomBarScreen.GantiKataSandi.route) {
            GantiKataSandiScreen(navController)
        }
        composable(route = Screen.RencanaPenggunaanDana.route) {
            RencanaPenggunaanDana(navController)
        }
        composable(route = Screen.About.route) {
            AboutScreen(navController)
        }
    }
}
