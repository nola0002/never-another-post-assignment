package com.bralogrithm.never_another.view.screens.home.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.R

@Composable
fun TwoByTwoGrid(modifier: Modifier = Modifier) {
    val images = listOf(
        R.drawable.homepage_1, R.drawable.homepage_2,
        R.drawable.homepage_3, R.drawable.homepage_4
    )
    Column(
        modifier = modifier.padding(16.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            GridItem(images[0], Modifier.weight(1f))
            GridItem(images[1], Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            GridItem(images[2], Modifier.weight(1f))
            GridItem(images[3], Modifier.weight(1f))
        }
    }
}

@Composable
fun GridItem(imageRes: Int, modifier: Modifier = Modifier) {
    Box(modifier = modifier.aspectRatio(1f)) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
