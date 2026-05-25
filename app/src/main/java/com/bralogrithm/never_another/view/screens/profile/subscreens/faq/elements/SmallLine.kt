package com.bralogrithm.never_another.view.screens.profile.subscreens.faq.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SmallLine() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 272.dp, top = 6.dp, bottom = 6.dp),
        thickness = 0.5.dp,
        color = Color.Black
    )
}