package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.Screen
import org.starlee.rangkulapp.ui.screencomponent.Display1
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@Composable
fun MulaiDonasiScreen(navController: NavHostController) {
    val blue = Color(0xFFA4E8FF)
    val backgroundclr = Color(0xFFE5EFF4)
    val darkenblue = Color(0xFF427CBF)

    // List of nominal options
    val nominalOptions = listOf("10k", "15k", "25k", "50k", "100k")
    // State to keep track of selected nominal
    val selectedNominal = remember { mutableStateOf("") }

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
                onClick = { navController.popBackStack() },
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

        Spacer(modifier = Modifier.height(170.dp))

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
                    text = stringResource(R.string.pilih_nominal),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
,
                            modifier = Modifier.fillMaxWidth() // Text occupies full width
                )

                // Defined value and onValueChange for OutlinedTextField
                OutlinedTextField(
                    value = selectedNominal.value,
                    onValueChange = { selectedNominal.value = it },
                    label = { Text(text = stringResource(R.string.minimal_donasi)) },
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(border = BorderStroke(1.dp, blue)),

                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.minimal),
                        color = blue,
                        textAlign = TextAlign.Start,
                        fontSize = 11.sp
                    )
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    // Horizontal scrollable row for nominal buttons
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(nominalOptions) { nominal ->
                            Button(
                                onClick = { selectedNominal.value = nominal },
                                modifier = Modifier.background(blue, RoundedCornerShape(10.dp)),
                                colors = ButtonDefaults.buttonColors(contentColor = Color.White),
                            ) {
                                Text(text = nominal, color = darkenblue)
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {navController.navigate(Screen.Transfer.route)},
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .background(blue, RoundedCornerShape(10.dp)), // Set background color to blue with rounded corners
                    colors = ButtonDefaults.buttonColors(contentColor = Color.Black), // Set text color to white
                ) {
                    Text(
                        text = stringResource(R.string.lanjutpembayaran),
                    )
                }
            }
        }
    }
    Display1()
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MulaiDonasiScreenPreview(){
    RangkulAppTheme {
        MulaiDonasiScreen(rememberNavController())
    }
}
