package org.starlee.rangkulapp.ui.screen

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
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
import androidx.compose.ui.platform.LocalContext
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
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@Composable
fun DetailRangkulPeduliScreen1(navController: NavHostController) {
    val blue = Color(0xFFA4E8FF)
    val backgroundclr = Color(0xFFE5EFF4)
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundclr),
        verticalArrangement = Arrangement.spacedBy(8.dp),
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
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .padding(start = 10.dp, end = 4.dp)
                    .size(28.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            Color.White,
                            RoundedCornerShape(100.dp)
                        )
                        .padding(5.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                // Membuat gambar lebih besar
                Image(
                    painter = painterResource(id = R.drawable.hope),
                    contentDescription = stringResource(R.string.voluntrip),
                    modifier = Modifier
                        .size(150.dp) // Ubah ukuran gambar
                )
                Text(
                    text = stringResource(R.string.hopewi),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = stringResource(R.string.hp),
                    textAlign = TextAlign.Start,
                    color = Color(0xFF2B5B94),
                    fontSize = 11.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {
                        val url = "https://www.hopeindonesia.org/relawan/"
                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(url)
                        }
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .background(blue, RoundedCornerShape(10.dp)),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.Black),
                ) {
                    Text(text = stringResource(R.string.daftarsekarang))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun DetailRangkulPeduliScreen1Preview() {
    RangkulAppTheme {
        DetailRangkulPeduliScreen1(rememberNavController())
    }
}
