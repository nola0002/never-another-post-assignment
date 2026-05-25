package com.bralogrithm.never_another.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun TextWithBrushStroke(
    text: String,
    fontSize: Int,
    fontWeight: FontWeight,
    boxHeight: Int,
    boxPaddingStart: Int,
    modifier: Modifier

){
    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(boxHeight.dp)
            .padding(start = boxPaddingStart.dp)
    ){
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontWeight = fontWeight,
            fontFamily = NohemiFontFamily
        )

        Image(
            painter = painterResource(R.drawable.brushstrokes),
            contentDescription = "Brush Stroke",
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}