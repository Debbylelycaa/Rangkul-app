package org.starlee.rangkulapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import org.starlee.rangkulapp.R


@Composable
fun SignupScreen(navigateToLogin: () -> Unit) {
    val backgroundImage = painterResource(id = R.drawable.background_image)

    val customColor = colorResource(id = R.color.ocean)

    val emailState = remember { mutableStateOf("") }
    val usernameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }
    val context = LocalContext.current

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
                    text = "Sign Up",
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
                        imeAction = ImeAction.Next // Mengubah imeAction menjadi Next
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
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
                    onClick = { /* Handle sign up */ },
                    modifier = Modifier.wrapContentWidth(), // Menggunakan wrapContentWidth() untuk menyesuaikan lebar tombol dengan teks di dalamnya
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Sign Up")
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
                        navigateToLogin()
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun SignupScreenPreview() {
    SignupScreen({})
}