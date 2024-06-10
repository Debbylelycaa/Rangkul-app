package org.starlee.rangkulapp.ui.screencomponent

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.BottomBarScreen

val list1 = listOf(
    NavBarItem(
        R.drawable.ic_info_topnavbar,
        "Info"
    ),
    NavBarItem(
        R.drawable.ic_donasi_topnavbar,
        "Donasi"
    ),
    NavBarItem(
        R.drawable.ic_rangkulasa_topnavbar,
        "Rangkul Asa"
    )
)

data class NavBarItem(
    @DrawableRes val icon: Int,
    val title: String
)

@Preview
@Composable
fun DisplayTopNavBar1(navController: NavHostController = rememberNavController()) {
    Column {
        TopNavBar1(1, list1, navController)
    }
}

@Composable
fun DisplayTopNavBar2(navController: NavHostController = rememberNavController()) {
    Column {
        TopNavBar2(1, list1, navController)
    }
}

@Composable
fun TopNavBar2(
    defaultSelectedIndex: Int = 0,
    list: List<NavBarItem>,
    navController: NavHostController
) {
    val linearGradientBrush = Brush.horizontalGradient(
        colors = listOf(Color(0xFF87E1FF), Color(0xFF3F72AF))
    )

    Box(
        Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(Color(0xFF82DEFF), RoundedCornerShape(0.1.dp))
    ) {
        var selectedIndex by remember {
            mutableIntStateOf(defaultSelectedIndex)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            IconButton(
                onClick = { navController.popBackStack()}, // Navigasi kembali
                modifier = Modifier
                    .padding(start = 10.dp, end = 4.dp)
                    .size(28.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            Color.White,
                            RoundedCornerShape(100.dp)
                        )
                        .padding(5.dp)
                )
            }

            list.forEachIndexed { index, navItem ->
                Box(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable {
                            selectedIndex = index
                            // Navigasi ke rute yang sesuai
                            when (index) {
                                0 -> navController.navigate(BottomBarScreen.InfoPenggalanganDana.route)
                                1 -> navController.navigate(BottomBarScreen.Donasi.route)
                                2 -> navController.navigate(BottomBarScreen.RangkulAsa.route)
                            }
                        },
                    contentAlignment = Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painterResource(navItem.icon),
                            contentDescription = null,
                            Modifier.size(24.dp),
                            tint = Color.Unspecified
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            navItem.title,
                            color = if (selectedIndex == index) Color.White else MaterialTheme.colorScheme.primary,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

    @Composable
    fun TopNavBar1(
        defaultSelectedIndex: Int = 0,
        list: List<NavBarItem>,
        navController: NavHostController
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(Color.White, RoundedCornerShape(10.dp))
        ) {
            var selectedIndex by remember {
                mutableIntStateOf(defaultSelectedIndex)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                list.forEachIndexed { index, navItem ->
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .clickable {
                                selectedIndex = index
                                // Navigasi ke rute yang sesuai
                                when (index) {
                                    0 -> navController.navigate(BottomBarScreen.InfoPenggalanganDana.route)
                                    1 -> navController.navigate(BottomBarScreen.Donasi.route)
                                    2 -> navController.navigate(BottomBarScreen.RangkulAsa.route)
                                }
                            },
                        contentAlignment = Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painterResource(navItem.icon),
                                contentDescription = null,
                                Modifier.size(24.dp),
                                tint = Color.Unspecified
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                navItem.title,
                                color = Color.Black,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }