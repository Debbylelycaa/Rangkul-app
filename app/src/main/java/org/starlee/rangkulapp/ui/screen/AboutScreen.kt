package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.model.Logo
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(33.dp)
                                .background(Color.White, shape = CircleShape)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.kembali),
                                tint = Color.Black
                            )
                        }
                    }
                },
                title = {
                    Text(text = stringResource(id = R.string.tentang_aplikasi),
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 15.sp
                        ),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { padding ->
        AboutContent(Modifier.padding())
    }
}

@Composable
fun AboutContent(modifier: Modifier){

    val logoprofil = Logo(R.drawable.logoprofil)

    Column (
        modifier = modifier
            .padding(top = 70.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(logoprofil.imageResId),
            contentDescription = stringResource(R.string.logoabout),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
        )
        Text(
            text = stringResource(R.string.copyright),
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 13.sp)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun AboutScreenPreview() {
    RangkulAppTheme {
        AboutScreen(rememberNavController())
    }
}
