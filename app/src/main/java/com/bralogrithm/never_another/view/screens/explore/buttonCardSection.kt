package com.bralogrithm.never_another.view.screens.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.R

@Composable
fun ButtonCardSection(
    image: Int,
    contentDescription: String,
    onClick: () -> Unit
){
    Button(colors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = Color.Black,
    ),
        modifier = Modifier
            .width(34.dp)
            .height(160.dp),
        contentPadding = PaddingValues(0.dp), // fjerner default padding i Button
        onClick = onClick) {
        Image(
            painter = painterResource(id = image),
            contentDescription = contentDescription,
            modifier = Modifier.size(28.dp)
        )
    }
}