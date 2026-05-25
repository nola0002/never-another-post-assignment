package com.bralogrithm.never_another.view.screens.profile.subscreens.faq.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily
import com.bralogrithm.never_another.view.components.Arrow

@Composable
fun FaqHeader(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp, start = 35.dp, top = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Arrow(onBackClick = onBackClick)
        Text(
            text = "FAQ",
            fontSize = 45.sp,
            fontWeight = Medium,
            fontFamily = NohemiFontFamily
        )
    }
}