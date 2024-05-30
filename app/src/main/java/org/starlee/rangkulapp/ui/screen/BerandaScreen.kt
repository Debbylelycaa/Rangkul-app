package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import org.starlee.rangkulapp.ui.screencomponent.DisplaySlider
import org.starlee.rangkulapp.ui.screencomponent.SearchBar
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@Composable
fun BerandaScreen (navController: NavHostController){
//    val linearGradientBrush = Brush.horizontalGradient(
//        colors = listOf(Color(0xFF50D1FF), Color(0xFFBDE2EF))
//    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar()
        DisplaySlider()

        Spacer(modifier = Modifier.height(30.dp))

//    Column(
//        modifier = Modifier.fillMaxWidth(),
//    ) {
//        // Horizontal scrollable row for nominal buttons
//        LazyRow(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            contentPadding = PaddingValues(horizontal = 16.dp),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//
//        }
//
//
//    }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF50D1FF)),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Tambahkan elevasi untuk bayangan
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.paahmadyani),
                        contentDescription = stringResource(R.string.ahmadyani),
                        alignment = Alignment.TopStart,
                        modifier = Modifier
                            .size(137.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya
                    Column {
                        Spacer(modifier = Modifier.padding(5.dp)) // Spacer untuk mengisi ruang kosong
                        Text(
                            text = stringResource(R.string.ahmadyani),
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Row {
                            Text(
                                text = stringResource(R.string.nominaltotal),
                                textAlign = TextAlign.Start,
                                fontSize = 10.sp,
                                color = Color(0xFF427CBF),
                                modifier = Modifier.weight(1f)
                            )

                            Text(
                                text = stringResource(R.string.sisahari),
                                textAlign = TextAlign.End,
                                fontSize = 10.sp,
                                color = Color(0xFF427CBF),
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(modifier = Modifier.width(18.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya

                        }

                        Spacer(modifier = Modifier.padding(5.dp)) // Spacer untuk mengisi ruang kosong

                        Row {

                            Text(
                                text = stringResource(R.string.alamat),
                                textAlign = TextAlign.Center,
                                fontSize = 11.sp,
                            )

                            Spacer(modifier = Modifier.weight(1f)) // Spacer untuk mengisi ruang kosong

                            Spacer(modifier = Modifier.weight(1f)) // Spacer untuk mengisi ruang kosong

                            Button(
                                onClick = { navController.navigate(Screen.MulaiDonasi.route) },
                                colors = ButtonDefaults.buttonColors(Color.White),
                                modifier = Modifier.height(30.dp), // Mengatur tinggi button agar lebih slim
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp) // Mengatur padding agar lebih slim
                            ) {
                                Text(
                                    text = stringResource(R.string.donasi),
                                    fontSize = 10.sp, // Ukuran font yang lebih kecil
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )
                            }

                            Spacer(modifier = Modifier.weight(0.5f)) // Spacer untuk mengisi ruang kosong

                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF50D1FF)),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Tambahkan elevasi untuk bayangan
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.pakaryaanakperdamaian),
                        contentDescription = stringResource(R.string.karyaanakperdamaian),
                        alignment = Alignment.TopStart,
                        modifier = Modifier
                            .size(137.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya
                    Column {
                        Spacer(modifier = Modifier.padding(5.dp)) // Spacer untuk mengisi ruang kosong
                        Text(
                            text = stringResource(R.string.karyaanakperdamaian),
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Row {
                            Text(
                                text = stringResource(R.string.nominaltotal),
                                textAlign = TextAlign.Start,
                                fontSize = 10.sp,
                                color = Color(0xFF427CBF),
                                modifier = Modifier.weight(1f)
                            )

                            Text(
                                text = stringResource(R.string.sisahari),
                                textAlign = TextAlign.End,
                                fontSize = 10.sp,
                                color = Color(0xFF427CBF),
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(modifier = Modifier.width(18.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya

                        }

                        Spacer(modifier = Modifier.padding(5.dp)) // Spacer untuk mengisi ruang kosong

                        Row {

                            Text(
                                text = stringResource(R.string.alamat),
                                textAlign = TextAlign.Center,
                                fontSize = 11.sp,
                            )

                            Spacer(modifier = Modifier.weight(1f)) // Spacer untuk mengisi ruang kosong

                            Spacer(modifier = Modifier.weight(1f)) // Spacer untuk mengisi ruang kosong

                            Button(
                                onClick = { navController.navigate(Screen.MulaiDonasi.route) },
                                colors = ButtonDefaults.buttonColors(Color.White),
                                modifier = Modifier.height(30.dp), // Mengatur tinggi button agar lebih slim
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp) // Mengatur padding agar lebih slim
                            ) {
                                Text(
                                    text = stringResource(R.string.donasi),
                                    fontSize = 10.sp, // Ukuran font yang lebih kecil
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Spacer(modifier = Modifier.weight(0.5f)) // Spacer untuk mengisi ruang kosong

                        }
                    }
                }
            }
        }
        Display1()

    }
}
@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun BerandaScreenPreview(){
    RangkulAppTheme {
        BerandaScreen(rememberNavController())
    }
}