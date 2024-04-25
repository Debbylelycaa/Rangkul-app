package org.starlee.rangkulapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.starlee.rangkulapp.navigation.SetupNavGraph
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RangkulAppTheme {

                SetupNavGraph()
            }
        }

    }
}