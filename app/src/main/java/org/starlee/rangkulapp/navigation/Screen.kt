package org.starlee.rangkulapp.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
    data object Email: Screen("emailScreen")
}