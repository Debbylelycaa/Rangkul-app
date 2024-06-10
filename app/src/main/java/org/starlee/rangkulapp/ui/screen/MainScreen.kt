package org.starlee.rangkulapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.navigation.BottomBarScreen
import org.starlee.rangkulapp.navigation.BottomNavGraph
import org.starlee.rangkulapp.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val showBottomBar = when (currentDestination?.route) {
        Screen.Login.route, Screen.SignUp.route, Screen.ForgotPassword.route -> false
        else -> true
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavController) {
    val screens = listOf(
        BottomBarScreen.RangkulPeduli,
        BottomBarScreen.Donasi,
        BottomBarScreen.Profil
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val linearGradientBrush = Brush.horizontalGradient(
        colors = listOf(Color(0xFF87E1FF), Color(0xFF3F72AF))
    )

    val birumuda = Color(0xFFDCF1F9)
    val birutua = Color(0xFF123054)

    NavigationBar {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .background(linearGradientBrush, RoundedCornerShape(1.dp))
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController,
                    birumuda = birumuda,
                    birutua = birutua
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavController,
    birumuda: Color,
    birutua: Color
) {
    val selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .weight(1f)
            .clickable {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            if (selected) Modifier.offset(y = (-8).dp) else Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier
                    .background(
                        if (selected) birumuda else Color.Transparent,
                        CircleShape
                    )
                    .size(50.dp), // Ukuran Box yang sama untuk semua ikon
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = screen.icon),
                    contentDescription = "Navigation Icon",
                    modifier = Modifier.size(30.dp), // Ukuran Icon yang sama untuk semua ikon
                    tint = Color.Unspecified
                )
            }

            AnimatedVisibility(selected) {
                Text(
                    screen.title,
                    modifier = Modifier.padding(top = 4.dp),
                    color = birutua,
                    fontSize = 12.sp
                )
            }
        }
    }
}
