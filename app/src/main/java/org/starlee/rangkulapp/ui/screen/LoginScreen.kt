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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import org.starlee.rangkulapp.R

@Composable
fun LoginScreen(
    navigateToSignup: () -> Unit,
    navigateToForgotPassword: (() -> Unit)? = null
) {
    val backgroundImage = painterResource(id = R.drawable.background_image)
    val ocean = colorResource(id = R.color.ocean)


    val usernameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val context = LocalContext.current

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
                                    fontSize = 14.sp,

                                    ),
                                start = 0,
                                end = length
                            )
                        },
                        onClick = {
                            navigateToSignup()
                        }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Handle login */ },
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
                        navigateToSignup()
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen({})
}