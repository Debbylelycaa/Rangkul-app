package org.starlee.rangkulapp.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("profilScreen")
    data object About : Screen("aboutScreen")
    data object Email : Screen("emailScreen")
    data object EditProfil : Screen("editProfilScreen")
    data object GantiKataSandi : Screen("gantiKataSandiScreen")
}

