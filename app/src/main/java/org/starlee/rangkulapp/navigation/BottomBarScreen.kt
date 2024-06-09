package org.starlee.rangkulapp.navigation

import org.starlee.rangkulapp.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
){

    object RangkulPeduli : BottomBarScreen(
        route = "rangkulpeduli",
        title = "RangkulPeduli",
        icon = R.drawable.ic_peduli_navbar
    )
    object Donasi : BottomBarScreen(
        route = "donasi",
        title = "Donasi",
        icon = R.drawable.ic_donasi_navbar
    )
    object Profil : BottomBarScreen(
        route = "profil",
        title = "Profil",
        icon = R.drawable.ic_profil_navbar
    )

    data object Home: Screen("BerandaScreen")
    data object DetailPembayaran: Screen("DetailPembayaranScreen")
    data object MulaiDonasi: Screen("MulaiDonasiScreen")
    data object PembayaranBerhasil: Screen("PembayaranBerhasilScreen")
    data object Terimakasih: Screen("TerimakasihScreen")
    data object Transfer: Screen("TransferScreen")
    data object InfoPenggalanganDana: Screen("InfoPenggalanganDanaScreen")
    data object RangkulAsa: Screen("RangkulAsaScreen")
    data object DetailDonasi: Screen("DetailDonasiScreen") // Perbaikan disini
    data object DetailRangkulPeduli: Screen("DetailRangkulPeduliScreen")
    data object EditProfil: Screen("EditProfilScreen")
    data object Email: Screen("EmailScreen")
    data object ForgotPassword: Screen("ForgotPasswordScreen")
    data object GantiKataSandi: Screen("GantiKataSandiScreen")

    data object About: Screen("AboutScreen")
}
