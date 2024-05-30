package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.Screen
import org.starlee.rangkulapp.ui.screencomponent.Display1
import org.starlee.rangkulapp.ui.screencomponent.DisplayTopNavBar1
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@Composable
fun DetailDonasiScreen(navController: NavHostController) {
    val blue = Color(0xFFA4E8FF)
    val backgroundclr = Color(0xFFE5EFF4)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundclr),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp) // Atur tinggi sesuai kebutuhan Anda
        ) {
            Image(
                painter = painterResource(id = R.drawable.pakaryaanakperdamaianinfo),
                contentDescription = stringResource(R.string.ahmadyani),
                contentScale = ContentScale.Crop, // Atur content scale sesuai kebutuhan
                modifier = Modifier.fillMaxSize()
            )

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .padding(16.dp)
                    .size(28.dp)
                    .background(
                        Color.White,
                        RoundedCornerShape(50)
                    )
                    .padding(4.dp),
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-60).dp) // Geser Card ke atas untuk menindih gambar
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp), // Tambahkan padding horizontal
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Tambahkan elevasi untuk bayangan
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(R.string.pantinama),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.jumlahdonasiterkirim),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Button(
                        onClick = { navController.navigate(Screen.DetailPembayaran.route) },
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .height(40.dp), // Mengatur tinggi button agar lebih slim
                        colors = ButtonDefaults.buttonColors(containerColor = blue, contentColor = Color.Black),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp) // Mengatur padding agar lebih slim
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_account_balance_wallet_24),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp) // Mengatur ukuran ikon agar lebih kecil
                        )
                        Text(
                            text = stringResource(R.string.rendanaaudit),
                            style = LocalTextStyle.current.copy(fontSize = 14.sp) // Mengatur ukuran teks agar lebih kecil
                        )
                    }
                }
            }

        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DisplayTopNavBar1()
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {navController.navigate(Screen.Transfer.route)},
            modifier = Modifier
                .padding(vertical = 8.dp)
                .background(blue, RoundedCornerShape(10.dp)), // Set background color to blue with rounded corners
            colors = ButtonDefaults.buttonColors(contentColor = Color.Black), // Set text color to white
        ) {
            Text(
                text = stringResource(R.string.donasisekarang),
            )
        }
        Display1()
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailDonasiScreenPreview() {
    RangkulAppTheme {
        DetailDonasiScreen(rememberNavController())
    }
}
