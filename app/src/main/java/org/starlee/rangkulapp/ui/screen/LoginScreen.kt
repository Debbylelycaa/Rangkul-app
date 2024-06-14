package org.starlee.rangkulapp.ui.screen


import LoginViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.Screen

@Composable
fun LoginScreen(navController: NavHostController, loginViewModel: LoginViewModel) {
    val backgroundImage = painterResource(id = R.drawable.background_image)
    val ocean = colorResource(id = R.color.ocean)

    val usernameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }

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
                    text = "Masuk",
                    fontSize = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Tampilkan pesan kesalahan jika ada
                if (errorMessage.value.isNotEmpty()) {
                    Text(
                        text = errorMessage.value,
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

                // TextField untuk nama pengguna
                OutlinedTextField(
                    value = usernameState.value,
                    onValueChange = { newValue ->
                        usernameState.value = newValue
                    },
                    label = { Text("Nama Pengguna", color = Color.Black) },
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
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ClickableText(
                        text = buildAnnotatedString {
                            append("Lupa kata sandi?")
                            addStyle(
                                style = SpanStyle(
                                    color = ocean,
                                    fontSize = 14.sp
                                ),
                                start = 0,
                                end = length
                            )
                        },
                        onClick = {
                            navController.navigate(Screen.ForgotPassword.route)
                        }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        // Validasi input pengguna
                        if (usernameState.value.isEmpty()) {
                            errorMessage.value = "Nama Pengguna tidak boleh kosong"
                        } else if (passwordState.value.isEmpty()) {
                            errorMessage.value = "Kata Sandi tidak boleh kosong"
                        } else {
                            errorMessage.value = ""
                            loginViewModel.validateLogin(
                                usernameState.value,
                                passwordState.value
                            ) { isValid ->
                                if (isValid) {
                                    navController.navigate(Screen.Home.route)
                                } else {
                                    errorMessage.value = "Nama Pengguna atau Kata Sandi salah"
                                }
                            }
                        }
                    },
                    modifier = Modifier.wrapContentWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Masuk")
                }
                Spacer(modifier = Modifier.height(8.dp))
                ClickableText(
                    text = buildAnnotatedString {
                        append("Belum punya akun? Daftar")
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
                        navController.navigate(Screen.SignUp.route)
                    }
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun LoginScreenPreview() {
//    val navController = rememberNavController()
//    val loginViewModel = LoginViewModel(MockDonaturDao()) // Gunakan UserDao palsu untuk preview
//
//    RangkulAppTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            LoginScreen(navController, loginViewModel)
//        }
//    }
//}
