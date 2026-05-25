package com.bralogrithm.never_another.view.screens.profile.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.model.InfoItem
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily
import kotlin.collections.forEach

@Composable
fun InfoSection(
    items: List<InfoItem>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp, top = 30.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "PERSONLIGE OPLYSNINGER",
            fontWeight = Medium,
            fontSize = 14.sp,
            fontFamily = NohemiFontFamily
        )
        items.forEach { item ->
            InfoStyle(title = item.title, value = item.value, icon = item.icon)
        }
    }
    SimpleLine()
}
