package com.bralogrithm.never_another.view.screens.home.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.model.BraColor
import com.bralogrithm.never_another.view.screens.explore.elements.ButtonCardSection
import com.bralogrithm.never_another.view.screens.explore.elements.TransparentButtonCardSection

@Composable
fun HomeSelectBra(
    modifier: Modifier = Modifier,
    selectedColor: BraColor,
    onToggleColor: () -> Unit
) {
    val imageRes = selectedColor.imageRes

    Box(
        modifier = modifier
            .width(315.dp)
            .height(315.dp)
    ) {
        // The Bra Packshot
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Bra Packshot",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )

        // Left Navigation Arrow
        ButtonCardSection(
            image = R.drawable.backlogocardsection,
            contentDescription = "Switch Color",
            onClick = onToggleColor,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = (-14).dp) // Offset to make it "peek out"
                .zIndex(1f)
        )

        // Large invisible hit area for easier clicking
        TransparentButtonCardSection(
            onClick = onToggleColor,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = (-50).dp)
                .zIndex(1f)
        )

        // Right Navigation Arrow
        ButtonCardSection(
            image = R.drawable.forwardlogocardsection,
            contentDescription = "Switch Color",
            onClick = onToggleColor,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = 14.dp)
                .zIndex(1f)
        )

        // Large invisible hit area for easier clicking
        TransparentButtonCardSection(
            onClick = onToggleColor,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = 50.dp)
                .zIndex(1f)
        )
    }
}

private val BraColor.imageRes: Int
    get() = when (this) {
        BraColor.White -> R.drawable.carrouselwhitebrafive
        BraColor.Black -> R.drawable.carrouselblackbrafour
    }
