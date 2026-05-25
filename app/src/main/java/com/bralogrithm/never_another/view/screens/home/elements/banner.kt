package com.bralogrithm.never_another.view.screens.home.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.ui.theme.Black
import com.bralogrithm.never_another.ui.theme.InterFontFamily
import com.bralogrithm.never_another.ui.theme.White

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Text(
        text = "Bestil i dag og få fri fragt — ".repeat(4).uppercase(),
        modifier = modifier.fillMaxWidth().background(Black).padding(vertical = 8.dp),
        maxLines = 1,
        softWrap = false,
        overflow = TextOverflow.Visible,
        fontFamily = InterFontFamily,
        fontSize = 16.sp,
        color = White,
        textAlign = TextAlign.Center
    )
}
