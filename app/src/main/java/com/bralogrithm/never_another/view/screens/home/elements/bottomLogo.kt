package com.bralogrithm.never_another.view.screens.home.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.R

@Composable
fun BottomLogo(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.homepage_logo),
            contentDescription = null,
            modifier = Modifier.size(102.dp, 88.dp),
            contentScale = ContentScale.Crop
        )
    }
}
