package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.Screen
import org.starlee.rangkulapp.ui.screencomponent.Display1
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@Composable
fun TerimakasihScreen(navController: NavHostController) {
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
                .padding(horizontal = 30.dp), // Add horizontal padding here
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.berhasil),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black

                )
                Spacer(modifier = Modifier.height(10.dp))

                // Menyisipkan gambar di sini
                Image(
                    painter = painterResource(id = R.drawable.check),
                    contentDescription = stringResource(R.string.pembayaranberhasilimg),
                    modifier = Modifier
                        .size(100.dp)
                        .padding(vertical = 8.dp)
                )

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.jumlahdonasiterkirim),
                        textAlign = TextAlign.Center,
                        color = Color.Black
,
                                modifier = Modifier.fillMaxWidth() // Text occupies full width
                    )
                }

                Button(
                    onClick = { navController.navigate(Screen.DetailPembayaran.route)  },
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .background(blue, RoundedCornerShape(10.dp)), // Set background color to blue with rounded corners
                    colors = ButtonDefaults.buttonColors(contentColor = Color.Black), // Set text color to black
                ) {
                    Text(
                        text = stringResource(R.string.detailPembayaran),
                    )
                }
            }
        }
        Display1()
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun TerimakasihScreenPreview() {
    RangkulAppTheme {
        TerimakasihScreen(rememberNavController())
    }
}
