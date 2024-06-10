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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.BottomBarScreen


@Composable
fun SignupScreen(navController: NavHostController ) {
    val backgroundImage = painterResource(id = R.drawable.background_image)

    val customColor = colorResource(id = R.color.ocean)

    val emailState = remember { mutableStateOf("") }
    val usernameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
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
                Image(
                    painter = painterResource(id = R.drawable.logo_3),
                    contentDescription = "Logo Aplikasi",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "Daftar",
                    fontSize = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = usernameState.value,
                    onValueChange = { newValue ->
                        usernameState.value = newValue
                    },
                    label = { Text("Nama Pengguna", color = Color.Black) },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = { newValue ->
                        emailState.value = newValue
                    },
                    label = { Text("Email", color = Color.Black) },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next // Mengubah imeAction menjadi Next
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                // TextField untuk kata sandi
                OutlinedTextField(
                    value = passwordState.value,
                    onValueChange = { newValue ->
                        passwordState.value = newValue
                    },
                    label = { Text("Kata Sandi", color = Color.Black) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(16.dp))
                // TextField untuk konfirmasi kata sandi
                OutlinedTextField(
                    value = confirmPasswordState.value,
                    onValueChange = { newValue ->
                        confirmPasswordState.value = newValue
                    },
                    label = { Text("Konfirmasi Kata Sandi", color = Color.Black) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate(BottomBarScreen.Login.route) },
                    modifier = Modifier.wrapContentWidth(), // Menggunakan wrapContentWidth() untuk menyesuaikan lebar tombol dengan teks di dalamnya
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Daftar")
                }
                Spacer(modifier = Modifier.height(8.dp))
                ClickableText(
                    text = buildAnnotatedString {
                        append("Sudah punya akun? Masuk")

                        addStyle(
                            style = SpanStyle(
                                color = customColor,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            start = 0,
                            end = length
                        )
                    },
                    onClick = {
                        navController.navigate(BottomBarScreen.Login.route)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun SignupScreenPreview() {
    SignupScreen(rememberNavController())
}