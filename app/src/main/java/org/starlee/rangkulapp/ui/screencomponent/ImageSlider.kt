package org.starlee.rangkulapp.ui.screencomponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.starlee.rangkulapp.R

//@Composable
//fun Slide() {
//    val images = listOf(
//        R.drawable.rangkulposter,
//        R.drawable.asaposter
//    )
//    ImageSliderWithIndicator(images = images)
//}

@Composable
fun ImageSliderItem(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(439.dp)
            .height(130.dp)
    )
}

@Composable
fun Indicator(active: Boolean) {
    val blue = Color(0xFF112D4E)
    val color = if (active) blue else Color.White
    val size = if (active) 5.dp else 5.dp
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .size(size)
    )
}
@Composable
fun ImageSliderWithIndicator(images: List<Int>) {
    val currentIndex = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            currentIndex.value = (currentIndex.value + 1) % images.size
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .height(130.dp) // Menambahkan height untuk mengatur posisi titik indikator ke atas
        ) {
            ImageSliderItem(imageRes = images[currentIndex.value])
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center // Untuk menyusun titik indikator di tengah
        ) {
            images.forEachIndexed { index, _ ->
                Indicator(active = index == currentIndex.value)
                if (index < images.size - 1) {
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun DisplaySlider() {
    val images = listOf(
        R.drawable.rangkulposter,
        R.drawable.asaposter
    )
    Column {
        ImageSliderWithIndicator(images = images)
    }
}
