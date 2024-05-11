package org.starlee.rangkulapp.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate(Screen.About.route)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = stringResource(R.string.tentang_aplikasi),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) {padding ->
        ScreenContent(Modifier.padding(padding))
    }
}

@Composable
fun ScreenContent(modifier: Modifier) {

}
//    Scaffold { padding ->
//        Box(modifier = Modifier.fillMaxSize()) {
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth() // Fill the width of the screen
//                    .height(100.dp) // Set the height of the blue background
//                    .padding(padding), // Apply padding from the Scaffold
//                color = Color(0xFFADD8E6) // Set the background color to blue
//            ) {
//
//            }
//
//            Surface(
//                modifier = Modifier
//                    .height(300.dp)
//                    .fillMaxWidth() // Mengisi lebar dan tinggi layar
//                    .padding(padding), // Terapkan padding dari Scaffold
//                color = Color(0xFFD4EBF9) // Ganti dengan warna latar belakang yang Anda inginkan
//            ) {
//
//            }
//            ScreenContent(Modifier.padding(padding))
//        }
//    }
//}

//@Composable
//fun ScreenContent(modifier: Modifier) {
//    Box(
//        modifier = modifier
//            .offset(y = 250.dp) // Mengatur offset vertikal agar ScreenContent berada di bawah MainScreen
//    ) {
//        Box(
//            modifier = Modifier
//                .align(Alignment.CenterStart)
//                .width(325.dp) // Mengatur lebar menjadi 50 DP
//                .height(200.dp) // Mengatur tinggi menjadi 50 DP
//                .background(Color.White, shape = RoundedCornerShape(16.dp)) // Mengatur latar belakang menjadi putih
//        ) {
//            // Isi konten ScreenContent di sini jika diperlukan
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun ScreenPreview() {
//    RangkulAppTheme {
//        ProfilScreen()
//    }
//}