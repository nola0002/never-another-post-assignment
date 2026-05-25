package com.bralogrithm.never_another.view.screens.profile.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.model.Label
import com.bralogrithm.never_another.model.SubScreensProfile
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily
import kotlin.collections.forEach

@Composable
fun ActionButtons(
    labels: List<Label>,
    onAction: (SubScreensProfile) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        labels.forEach { label ->
            Button(
                modifier = Modifier
                    .width(340.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF2F2F2),
                    contentColor = Color.Black
                ),
                onClick = { onAction(label.subScreen) }
            ) {
                Text(
                    text = label.labelName,
                    fontFamily = NohemiFontFamily,
                    fontSize = 15.sp,
                )
            }
        }
    }
}