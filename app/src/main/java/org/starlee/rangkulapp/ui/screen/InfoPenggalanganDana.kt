package org.starlee.rangkulapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoPenggalanganDana(){
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

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ScreenContent(modifier: Modifier){
    val pagerState = rememberPagerState()
    val tabData = listOf("Tab1" to Icons.Default.Home, "Tab2" to Icons.Default.Settings)
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            divider = {
                Spacer(modifier = Modifier.height(5.dp))
            },
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
//                    modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    height = 5.dp,
                    color = Color.White
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            tabData.forEachIndexed { index, s ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    icon = {
                        Icon(imageVector = s.second, contentDescription = null)
                    },
                    text = {
                        Text(text = s.first)
                    }
                )
            }
        }
        HorizontalPager(count = tabData.size, state = pagerState) { page ->
            // Your content for each page
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ScreenPreview() {
    RangkulAppTheme {
        InfoPenggalanganDana()
    }
}
