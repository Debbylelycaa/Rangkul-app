package org.starlee.rangkulapp.ui.screencomponent

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.navigation.Screen

data class NavItem(
    @DrawableRes val icon: Int,
    val title: String
)

val list2 = listOf(
    NavItem(
        R.drawable.ic_peduli_navbar,
        "Rangkul Peduli"
    ),
    NavItem(
        R.drawable.ic_donasi_navbar,
        "Donasi"
    ),
    NavItem(
        R.drawable.ic_profil_navbar,
        "Profil"
    )
)

@Preview
@Composable
fun Display1(navController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        NavBar2(1, list2, navController)
    }
}


@Composable
fun NavBar2(
    defaultSelectedIndex: Int = 0,
    list: List<NavItem>,
    navController: NavHostController
) {
    val linearGradientBrush = Brush.horizontalGradient(
        colors = listOf(Color(0xFF87E1FF), Color(0xFF3F72AF))
    )

    val birumuda = Color(0xFFDCF1F9)
    val birutua = Color(0xFF123054)

    Box(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(linearGradientBrush, RoundedCornerShape(8.dp))
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
                            when (index) {
                                0 -> navController.navigate(Screen.RangkulPeduli.route)
                                1 -> navController.navigate(Screen.Donasi.route)
                                2 -> navController.navigate(Screen.RangkulAsa.route)
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        if (selectedIndex == index) Modifier.offset(y = (-8).dp)
                        else Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            Modifier
                                .background(
                                    if (selectedIndex == index) birumuda
                                    else Color.Transparent,
                                    CircleShape
                                )
                                .size(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painterResource(navItem.icon),
                                contentDescription = null,
                                Modifier.size(40.dp),
                                tint = Color.Unspecified
                            )
                        }

                        AnimatedVisibility(selectedIndex == index) {
                            Text(
                                navItem.title,
                                modifier = Modifier.padding(top = 4.dp),
                                color = birutua,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
