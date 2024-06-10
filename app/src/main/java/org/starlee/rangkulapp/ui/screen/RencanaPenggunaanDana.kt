package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@Composable
fun RencanaPenggunaanDana(navController: NavHostController) {
    val blue = Color(0xFFA4E8FF)
    val backgroundclr = Color(0xFFE5EFF4)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundclr),
        verticalArrangement = Arrangement.spacedBy(8.dp), // Spacing between items
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            colors = CardDefaults.cardColors(containerColor = backgroundclr),
            border = null
        ) {
            IconButton(
                onClick = {navController.popBackStack()  },
                modifier = Modifier
                    .padding(start = 10.dp, end = 4.dp)
                    .size(28.dp) // Adjusted size for smaller button

            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .size(30.dp) // Adjusted size for smaller button
                        .background(
                            Color.White,
                            RoundedCornerShape(100.dp) // Adjusted rounding for smaller button
                        )
                        .padding(5.dp)

                )
            }
        }

        Spacer(modifier = Modifier.height(120.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),  // Add horizontal padding here
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.RencanaPenggunaanDana),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black

                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = stringResource(R.string.sttsdana),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 12.sp, // Set the font size to 16sp
                    modifier = Modifier.fillMaxWidth() // Text occupies full width
                )

                Spacer(modifier = Modifier.height(5.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, blue)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stringResource(R.string.danaterkumpul),
                                textAlign = TextAlign.Start,
                                fontSize = 11.sp,                color = Color.Black,
                                modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya
                            Text(
                                text = stringResource(R.string.dana),
                                textAlign = TextAlign.Start,
                                fontSize = 11.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stringResource(R.string.danaoperasional),
                                textAlign = TextAlign.Start,
                                fontSize = 11.sp,
                                color = Color.Black,
                                modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya
                            Text(
                                text = stringResource(R.string.opr),
                                textAlign = TextAlign.Start,
                                fontSize = 11.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stringResource(R.string.admin),
                                textAlign = TextAlign.Start,
                                fontSize = 11.sp,
                                color = Color.Black,
                                modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya
                            Text(
                                text = stringResource(R.string.bank),
                                textAlign = TextAlign.Start,
                                fontSize = 11.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stringResource(R.string.Danatersisa),
                                textAlign = TextAlign.Start,
                                fontSize = 11.sp,
                                color = Color.Black,
                                modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya
                            Text(
                                text = stringResource(R.string.sisa),
                                textAlign = TextAlign.Start,
                                fontSize = 11.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                            )
                        }
                    }
                }
            }
        }
//        Display1()
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun RencanaPenggunaanDanaScreenPreview(){
    RangkulAppTheme {
        RencanaPenggunaanDana(rememberNavController())
    }
}
