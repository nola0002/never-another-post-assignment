package com.bralogrithm.never_another.view.screens.explore.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorDotCarrousel(
    color: Color,
    selected: Boolean,
    onClick: () -> Unit
) {
    val borderShape = RoundedCornerShape(6.dp)

    val boxShape = RoundedCornerShape(4.dp)

    // Box der sikre ydre box der sikre at de ikke skubber til hinaden når der kommer flere
    Box(
        modifier = Modifier
            .size(30.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        //Boxen
        Box(
            modifier = Modifier
                .size(23.dp)
                .background(color, boxShape)
        )

        //Ring rundt om Boxen
        if (selected) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .border(2.dp, color, borderShape) // eller Color.White for sort dot
            )
        }
    }
}

