package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.PersonPin
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.Screen
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .statusBarsPadding()
                        .fillMaxWidth()
                ) {
                    // Background Image
                    Image(
                        painter = painterResource(id = R.drawable.background1),
                        contentDescription = "Background Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), // Atur tinggi gambar
                        contentScale = ContentScale.Crop
                    )
                }
            }
        ) { padding ->
            ScreenContent(Modifier.padding(padding), navController)
        }

        // Profile Picture with white circle background
        Box(
            modifier = Modifier
                .size(108.dp)
                .offset(y = 50.dp) // Memindahkan profil pic ke bawah
                .align(Alignment.TopCenter) // Menempatkan profil pic di tengah atas
                .zIndex(1f) // Memastikan profil pic berada di depan background
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(7.dp) // Margin untuk lingkaran putih
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profilpic),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun ScreenContent(modifier: Modifier = Modifier, navController: NavHostController) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background Image for ScreenContent
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "Screen Content Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 55.dp, start = 16.dp, end = 16.dp), // Changed top padding to 80.dp
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Khalilah Atika Akmal",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp) // Added bottom padding
            )
            Spacer(modifier = Modifier.height(25.dp))

            Box(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HoverButton(
                        onClick = { navController.navigate(Screen.EditProfil.route) },
                        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp))
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.PersonPin,
                                contentDescription = "Profile Icon",
                                modifier = Modifier.padding(end = 8.dp) // Adjust the padding as needed
                            )
                            Text(text = "Edit Profil", fontSize = 14.sp )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    HoverButton(
                        onClick = { navController.navigate(Screen.Email.route) },
                        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp))
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Key,
                                contentDescription = "Ganti Kata Sandi Icon",
                                modifier = Modifier.padding(end = 8.dp) // Adjust the padding as needed
                            )
                            Text(text = "Ganti Kata Sandi", fontSize = 14.sp )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    HoverButton(
                        onClick = { navController.navigate(Screen.About.route) },
                        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp))
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = "Tentang Aplikasi Icon",
                                modifier = Modifier.padding(end = 8.dp) // Adjust the padding as needed
                            )
                            Text(text = "Tentang Aplikasi", fontSize = 14.sp )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun HoverButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    val customColor = colorResource(id = R.color.custom_blue)
    val backgroundColor by animateColorAsState(if (isPressed) customColor else Color.Transparent)

    Box(
        modifier = modifier
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .border(BorderStroke(1.dp, Color.Transparent), shape = RoundedCornerShape(8.dp)) // Atur warna border menjadi transparan
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                onClick = {
                    isPressed = !isPressed
                    onClick()
                },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ProfilScreenPreview() {
    RangkulAppTheme {
        ProfilScreen(rememberNavController())
    }
}
