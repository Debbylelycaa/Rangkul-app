package org.starlee.rangkulapp.ui.screen

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
fun RangkulPeduliScreen (navController: NavHostController){
    val context = LocalContext.current

    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(Color(0xFF50D1FF), Color(0xFFBDE2EF), Color(0xFFBDE2EF))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.rangkulpeduliposter),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(439.dp)
                .height(130.dp)
        )


        //SearchBar()
        Spacer(modifier = Modifier.height(30.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(8.dp) // Atur sesuai dengan kebutuhan
            ) {
                Column(
                    modifier = Modifier.background(gradientBrush),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RangkulPeduliCardContent1(rememberNavController())
                }
            }
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(8.dp) // Atur sesuai dengan kebutuhan
        ) {
            Column(
                modifier = Modifier.background(gradientBrush),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RangkulPeduliCardContent(rememberNavController())
            }
        }


    }
}

@Composable
fun RangkulPeduliCardContent(navController: NavHostController) {
    val currentContext = LocalContext.current // Rename context to currentContext

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.kitabisa),
            contentDescription = stringResource(R.string.kitabisajudul),
            alignment = Alignment.TopStart,
            modifier = Modifier.size(137.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = stringResource(R.string.kitabisajudul),
                textAlign = TextAlign.Center,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black

            )
            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(
                    text = stringResource(R.string.kitabisatgl),
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        lineHeight = 12.sp  // Mengatur tinggi baris lebih kecil dari fontSize
                    ),
                    fontSize = 11.sp,
                    color = Color.Black

                )
                Spacer(modifier = Modifier.weight(1f))

                Button(
//                    onClick = { navController.navigate(BottomBarScreen.DetailRangkulPeduli.route) },
                    onClick = {
                        val url = "https://www.hopeindonesia.org/relawan/"
                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(url)
                        }
                        currentContext.startActivity(intent) // Use currentContext here
                    },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier.height(30.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.detail),
                        fontSize = 10.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }


                Spacer(modifier = Modifier.weight(0.5f))
            }
        }
    }
}



@Composable
fun RangkulPeduliCardContent1(navController: NavHostController) {
    val currentContext = LocalContext.current // Rename context to currentContext

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.hope),
            contentDescription = stringResource(R.string.voluntrip),
            alignment = Alignment.TopStart,
            modifier = Modifier.size(137.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = stringResource(R.string.hopewi),
                textAlign = TextAlign.Center,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black

            )
            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(
                    text = stringResource(R.string.hopetgl),
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        lineHeight = 12.sp  // Mengatur tinggi baris lebih kecil dari fontSize
                    ),
                    fontSize = 11.sp,
                    color = Color.Black

                )
                Spacer(modifier = Modifier.weight(1f))

                Button(
//                    onClick = { navController.navigate(BottomBarScreen.DetailRangkulPeduli1.route) },
                    onClick = {
                        val url = "https://www.hopeindonesia.org/relawan/"
                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(url)
                        }
                        currentContext.startActivity(intent) // Use currentContext here
                    },

//                    onClick = {
//                        val url = "https://www.hopeindonesia.org/relawan/"
//                        val intent = Intent(Intent.ACTION_VIEW).apply {
//                            data = Uri.parse(url)
//                        }
//                        currentContext.startActivity(intent)
//                    },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier.height(30.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.detail),
                        fontSize = 10.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }


                Spacer(modifier = Modifier.weight(0.5f))
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun RangkulPeduliScreenPreview(){
    RangkulAppTheme {
        RangkulPeduliScreen(rememberNavController())
    }
}
