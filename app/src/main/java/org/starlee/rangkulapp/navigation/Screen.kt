package org.starlee.rangkulapp.navigation

sealed class Screen (val route: String){
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
}
