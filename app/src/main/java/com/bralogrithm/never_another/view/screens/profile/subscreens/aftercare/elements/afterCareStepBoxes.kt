package com.bralogrithm.never_another.view.screens.profile.subscreens.aftercare.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun AfterCareStepBoxes(
    boxColor: Color,
    stepNumber: String,
    stepText: String,
    numberOnLeft: Boolean, // true = hvid-stil, false = sort-stil
) {
    val textColor = if (boxColor == Color.White) Color.Black else Color.White

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(118.dp)
            .background(boxColor),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 54.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Venstre "slot"
            Text(
                text = if (numberOnLeft) stepNumber else "",
                fontFamily = NohemiFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 36.sp,
                color = textColor
            )

            // Midterfelt
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = stepText,
                    fontFamily = NohemiFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 32.sp,
                    color = textColor,
                    maxLines = 2
                )
            }

            // Højre "slot"
            Text(
                text = if (numberOnLeft) "" else stepNumber,
                fontFamily = NohemiFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 36.sp,
                color = textColor
            )
        }
    }
}