package com.bralogrithm.never_another.view.screens.explore.elements

/*
 * Lavet af Noah
 *
 * Synlig pil-knap der bruges som tilbage/frem-knap på karruselerne.
 * Selve ikonet kommer ind via image-parameteren.
 *
 */

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCardSection(
    image: Int,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier

){
    Button(colors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = Color.Black,
    ),
        modifier = modifier
            .width(34.dp)
            .height(160.dp),
        contentPadding = PaddingValues(0.dp),
        onClick = onClick) {
        Image(
            painter = painterResource(id = image),
            contentDescription = contentDescription,
            modifier = Modifier.size(28.dp)
        )
    }
}