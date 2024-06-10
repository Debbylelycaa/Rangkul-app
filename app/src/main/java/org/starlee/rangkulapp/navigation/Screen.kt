package org.starlee.rangkulapp.navigation

sealed class Screen (val route: String){
    data object Login: Screen("LoginScreen")
    data object SignUp: Screen("SignUpScreen")

    data object Home: Screen("BerandaScreen")
    data object DetailPembayaran: Screen("DetailPembayaranScreen")
    data object MulaiDonasi: Screen("MulaiDonasiScreen")
    data object PembayaranBerhasil: Screen("PembayaranBerhasilScreen")
    data object Terimakasih: Screen("TerimakasihScreen")
    data object Transfer: Screen("TransferScreen")
    data object InfoPenggalanganDana: Screen("InfoPenggalanganDanaScreen")
    data object Donasi: Screen("DonasiScreen")
    data object RangkulAsa: Screen("RangkulAsaScreen")
    data object DetailDonasi: Screen("DetailDonasiScreen") // Perbaikan disini
    data object RangkulPeduli: Screen("RangkulPeduliScreen")
    data object DetailRangkulPeduli: Screen("DetailRangkulPeduliScreen")
    data object DetailRangkulPeduli1: Screen("DetailRangkulPeduliScreen1")

    data object EditProfil: Screen("EditProfilScreen")
    data object Profil: Screen("ProfilScreen")
    data object Email: Screen("EmailScreen")
    data object ForgotPassword: Screen("ForgotPasswordScreen")
    data object GantiKataSandi: Screen("GantiKataSandiScreen")

    data object About: Screen("AboutScreen")
    data object RencanaPenggunaanDana: Screen("RencanaPenggunaanDana")



}
