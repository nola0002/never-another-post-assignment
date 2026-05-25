package com.bralogrithm.never_another.view.screens.home.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.model.BraColor
import com.bralogrithm.never_another.ui.theme.InterFontFamily
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily
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
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Bra Packshot",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )

        ButtonCardSection(
            image = R.drawable.backlogocardsection,
            contentDescription = "Switch Color",
            onClick = onToggleColor,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = (-14).dp)
                .zIndex(1f)
        )

        TransparentButtonCardSection(
            onClick = onToggleColor,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = (-50).dp)
                .zIndex(1f)
        )

        ButtonCardSection(
            image = R.drawable.forwardlogocardsection,
            contentDescription = "Switch Color",
            onClick = onToggleColor,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = 14.dp)
                .zIndex(1f)
        )

        TransparentButtonCardSection(
            onClick = onToggleColor,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = 50.dp)
                .zIndex(1f)
        )
    }
    Column() {
        Text(
            text = "skræddersyet bh ",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = NohemiFontFamily,
                fontWeight = FontWeight(500),
                color = Color.Black,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        )
        Text(
            text = "DKK 799",
            style = TextStyle(
                fontSize = 13.sp,
                lineHeight = 19.5.sp,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight(300),
                color = Color.Black,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
    }
}

private val BraColor.imageRes: Int
    get() = when (this) {
        BraColor.White -> R.drawable.carrouselwhitebrafive
        BraColor.Black -> R.drawable.carrouselblackbrafour
    }
