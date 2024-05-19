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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.Screen
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate(Screen.About.route)
                        }
                    ) {
//                        Icon(
//                            imageVector = Icons.Outlined.Info,
//                            contentDescription = stringResource(R.string.tentang_aplikasi),
//                            tint = MaterialTheme.colorScheme.primary
//                        )
                    }
                }
            )
        }
    ) {padding ->
        ScreenContent(Modifier.padding(padding), navController)
    }
}

@Composable
fun ScreenContent(modifier: Modifier = Modifier, navController: NavHostController) {
    val customColor = colorResource(id = R.color.custom_blue)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Container informasi pengguna
        Image(
            painter = painterResource(id = R.drawable.profilpic), // Ganti dengan resource gambar Anda
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(108.dp)
                .clip(CircleShape)
                .background(customColor)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Khalilah Atika Akmal",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(60.dp))

        // Container untuk tombol-tombol
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Tombol edit profil
                HoverButton(onClick = { navController.navigate(Screen.EditProfil.route) },
                    modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Edit Profil")
                }
                Spacer(modifier = Modifier.height(8.dp))
                // Tombol ubah kata sandi
                HoverButton(
                    onClick = { navController.navigate(Screen.GantiKataSandi.route) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Ganti Kata Sandi")
                }
                Spacer(modifier = Modifier.height(8.dp))
                // Tombol tentang aplikasi
                HoverButton(
                    onClick = { navController.navigate(Screen.About.route) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Tentang Aplikasi")
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
            .background(backgroundColor, shape = RoundedCornerShape(4.dp))
            .border(BorderStroke(1.dp, customColor), shape = RoundedCornerShape(4.dp))
            .clip(RoundedCornerShape(4.dp))
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(12.dp),
        contentAlignment = Alignment.Center
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
