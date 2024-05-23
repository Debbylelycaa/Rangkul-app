package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerandaScreen(){
    val barcolor = Color(0xFF82DEFF)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                navigationIcon = {
                    IconButton(
                        onClick = { }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = stringResource(R.string.uploadbukti),
                            modifier = Modifier
                                .size(28.dp)
                                .background(
                                    Color.White,
                                    RoundedCornerShape(90.dp)
                                )
                                .padding(3.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = barcolor, // Ganti warna TopAppBar di sini
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { padding ->
        ScreenContent(Modifier.padding(padding))
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun BerandaScreenPreview() {
    RangkulAppTheme {
        BerandaScreen()
    }
}
