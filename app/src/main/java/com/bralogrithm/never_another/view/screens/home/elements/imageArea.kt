package com.bralogrithm.never_another.view.screens.home.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.ui.theme.Black
import com.bralogrithm.never_another.ui.theme.White

@Composable
fun ImageArea(modifier: Modifier = Modifier) {
    Box(modifier = modifier.height(590.dp)) {
        Image(
            painter = painterResource(id = R.drawable.landing_page_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp)
        ) {
            Text("Digitalt ".uppercase(), style = MaterialTheme.typography.titleLarge, color = Black)
            Text("Skrædderet".uppercase(), style = MaterialTheme.typography.titleLarge, color = White)
        }
    }
}
