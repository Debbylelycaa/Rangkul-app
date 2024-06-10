package org.starlee.rangkulapp.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.BottomBarScreen


@Composable
fun ForgotPasswordScreen(
    navController: NavHostController// Parameter untuk kembali ke layar masuk
) {
    val backgroundImage = painterResource(id = R.drawable.background_image)
    val ocean = colorResource(id = R.color.ocean)

    // State untuk menyimpan nilai email
    val emailState = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Gambar latar belakang
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp),
            color = Color.Transparent
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Lupa Kata Sandi",
                    fontSize = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                // TextField untuk email
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = { newValue ->
                        emailState.value = newValue
                    },
                    label = { Text("Email", color = Color.Black) },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Handle forgot password */ },
                    modifier = Modifier.wrapContentWidth(), // Menggunakan wrapContentWidth() untuk menyesuaikan lebar tombol dengan teks di dalamnya
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Kirim Email")
                }
                Spacer(modifier = Modifier.height(8.dp))
                ClickableText(
                    text = buildAnnotatedString {
                        append("Ganti Kata Sandi")

                        addStyle(
                            style = SpanStyle(
                                color = ocean,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            start = 0,
                            end = length
                        )
                    },
                    onClick = {
                        navController.navigate(BottomBarScreen.Login.route) // Kembali ke layar masuk
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen(rememberNavController())
}