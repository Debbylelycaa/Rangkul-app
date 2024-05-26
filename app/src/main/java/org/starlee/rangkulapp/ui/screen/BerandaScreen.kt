package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@Composable
fun BerandaScreen (navController: NavHostController){

}
@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun BerandaScreenPreview(){
    RangkulAppTheme {
        BerandaScreen(rememberNavController())
    }
}