package com.bralogrithm.never_another.view.screens.profile.subscreens.faq.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun QuestionStyle(
    title: String,
    answer: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF2F2F2))
            .padding(13.dp)
            .width(325.dp),
    ) {
        Column() {
            Text(
                text = title,
                fontWeight = Medium,
                fontFamily = NohemiFontFamily
            )
            SmallLine()
            Text(
                text = answer,
                fontWeight = FontWeight.ExtraLight,
                fontFamily = NohemiFontFamily,
                fontSize = 15.sp
            )
        }
    }
}
