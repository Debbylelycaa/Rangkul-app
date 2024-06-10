package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import org.starlee.rangkulapp.navigation.BottomBarScreen
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@Composable
fun TransferScreen(navController: NavHostController) {
    val blue = Color(0xFFA4E8FF)
    val backgroundclr = Color(0xFFE5EFF4)
    val darkenblue = Color(0xFF427CBF)

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

        Spacer(modifier = Modifier.height(90.dp))

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
                    text = stringResource(R.string.pembayaran),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
,
                            modifier = Modifier.fillMaxWidth() // Text occupies full width
                )

                // Defined value and onValueChange for OutlinedTextField
                var nominal by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = nominal,
                    onValueChange = { nominal = it },
                    label = {
                        Text(
                            text = stringResource(R.string.nominalsepuluh),
                            textAlign = TextAlign.Center // Menempatkan teks di tengah
                        )
                    },
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                    modifier = Modifier
                        .border(border = BorderStroke(1.dp, blue))
                )
                Spacer(modifier = Modifier.height(15.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(R.string.bri),
                        textAlign = TextAlign.Start,
                        fontSize = 11.sp,
                        color = Color.Black
,
                                modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya
                    Text(
                        text = stringResource(R.string.debby),
                        textAlign = TextAlign.End,
                        fontSize = 11.sp,
                        color = Color.Black,
                                modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                    )
                }
                Divider(
                    Modifier.fillMaxWidth(),
                    color = Color.Gray
                ) // Garis pemisah antara bri dan mandiri
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(R.string.Mandiri),
                        textAlign = TextAlign.Start,
                        fontSize = 11.sp,                        color = Color.Black,


                        modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Spacer untuk memberikan jarak antara teks dan teks selanjutnya
                    Text(
                        text = stringResource(R.string.dianne),
                        textAlign = TextAlign.End,
                        fontSize = 11.sp,
                        color = Color.Black,

                        modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                    )
                }

                Column {
                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(45.dp)
                    ) {

                        Text(
                            text = stringResource(R.string.opsianonim),
                            textAlign = TextAlign.Start,
                            fontSize = 11.sp,
                            color = Color.Black,

                            modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                        )

                        var isChecked by remember { mutableStateOf(false) }
                        Switch(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it },
                            modifier = Modifier
                                .size(1.dp)
                                .border(BorderStroke(0.dp, Color.Transparent)),
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = darkenblue,
                                checkedTrackColor = darkenblue.copy(alpha = 0.5f),
                                uncheckedThumbColor = blue,
                                uncheckedTrackColor = blue.copy(alpha = 0.5f)
                            ),
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                    }

                    Spacer(modifier = Modifier.height(15.dp))
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {

                    Row {
                        Text(
                            text = stringResource(R.string.asa),
                            textAlign = TextAlign.Start,
                            fontSize = 11.sp,
                            color = Color.Black,

                            modifier = Modifier.weight(1f) // Memanfaatkan ruang sebanyak mungkin
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    var asa by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = asa,
                        onValueChange = { asa = it },
                        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(border = BorderStroke(1.dp, blue))
                    )
                }
                Button(
                    onClick = { navController.navigate(BottomBarScreen.PembayaranBerhasil.route) },
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .background(blue, RoundedCornerShape(10.dp)),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.Black),
                ) {
                    Text(
                        text = stringResource(R.string.lanjutpembayaran),
                    )
                }
            }
        }
//        Display1()
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun TransferScreenPreview(){
    RangkulAppTheme {
        TransferScreen(rememberNavController())
    }
}
