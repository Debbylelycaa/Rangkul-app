package org.starlee.rangkulapp

import LoginViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import org.starlee.rangkulapp.data.Rangkuldb
import org.starlee.rangkulapp.ui.screen.MainScreen
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Rangkuldb.getInstance(applicationContext)
        val donaturDao = db.donaturDao()
        val loginViewModel = LoginViewModel(donaturDao)

        setContent {
            RangkulAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(loginViewModel)
                }
            }
        }
    }
}