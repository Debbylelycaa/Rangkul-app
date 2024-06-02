package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
import org.starlee.rangkulapp.ui.screencomponent.DisplayTopNavBar2
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@Composable
fun RangkulAsaScreen (navController: NavHostController){
    val linearGradientBrush = Brush.horizontalGradient(
        colors = listOf(Color(0xFF50D1FF), Color(0xFFBDE2EF))
    )
    val blue = Color(0xFFA4E8FF)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplayTopNavBar2()

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.donatur),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black
,
                        modifier = Modifier.fillMaxWidth() // Text occupies full width
            )
            Text(
                text = stringResource(R.string.jlhdonatur),
                textAlign = TextAlign.Start,
                fontSize = 11.sp,
                modifier = Modifier
                    .background(Color(0xFF50D1FF), RoundedCornerShape(100.dp))
                    .padding(2.dp) // Memanfaatkan ruang sebanyak mungkin
            )
            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFD2F4FF)),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.ic_sahabatbaik),
                            contentDescription = null,
                            Modifier.size(60.dp),
                            tint = Color.Unspecified,
                        )
                        Spacer(modifier = Modifier.width(10.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya

                        Column {
                            Spacer(modifier = Modifier.width(10.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya
                            Text(
                                text = stringResource(R.string.shbtbaik),
                                textAlign = TextAlign.Start,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Row {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_history_24),
                                    contentDescription = null,
                                    Modifier.size(15.dp),
                                    tint = Color.Unspecified,
                                )
                                Text(
                                    text = stringResource(R.string.menit),
                                    textAlign = TextAlign.Start,
                                    fontSize = 9.sp,
                                    color = Color(0xFF427CBF),
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = stringResource(R.string.isiasa),
                                textAlign = TextAlign.Start,
                                fontSize = 10.sp,
                                color = Color(0xFF000000),
                                modifier = Modifier.fillMaxWidth(), // Text occupies full width
                                style = androidx.compose.ui.text.TextStyle(
                                    lineHeight = 15.sp // Set line height to 20 sp
                                )
                            )
                        }

                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(120.dp))

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
fun RangkulAsaScreenPreview(){
    RangkulAppTheme {
        RangkulAsaScreen(rememberNavController())
    }
}