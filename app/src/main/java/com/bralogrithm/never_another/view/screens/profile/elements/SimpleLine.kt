package com.bralogrithm.never_another.view.screens.profile.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleLine() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 130.dp, vertical = 30.dp),

        thickness = 1.dp,
        color = Color.Black
    )
} // https://claude.ai/share/5fe2c205-63bb-4bed-bf95-902bb2e068f6
