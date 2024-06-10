package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
import org.starlee.rangkulapp.navigation.BottomBarScreen
import org.starlee.rangkulapp.ui.screencomponent.Display1
import org.starlee.rangkulapp.ui.screencomponent.DisplayTopNavBar2
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@Composable
fun InfoPenggalanganDanaScreen (navController: NavHostController){
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

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.infopenggalangandana),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                        modifier = Modifier.fillMaxWidth() // Text occupies full width
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.infokaryaanakperdamaian),
                textAlign = TextAlign.Start,
                color = Color.Black
,
                        fontSize = 10.sp,
                modifier = Modifier.fillMaxWidth() // Text occupies full width
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {navController.navigate(BottomBarScreen.Transfer.route)},
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
fun InfoPenggalanganDanaScreenPreview(){
    RangkulAppTheme {
        InfoPenggalanganDanaScreen(rememberNavController())
    }
}