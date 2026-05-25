package com.bralogrithm.never_another.view.screens.profile.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun InfoStyle(
    title: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(Color(0xFFF2F2F2))
            .padding(7.dp)
            .width(325.dp)
    ) {
        Column(
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.padding(end = 12.dp)
            ) // https://claude.ai/share/cd4ff895-8567-408c-9f59-55b27e1ab9fe
        }
        Column() {
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraLight,
                fontFamily = NohemiFontFamily
            )
            Text(
                text = value,
                fontFamily = NohemiFontFamily
            )
        }
    }
}
