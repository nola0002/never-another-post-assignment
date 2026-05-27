package com.bralogrithm.never_another.view.screens.order.elements

/*
 * Lavet af Sylvester
 *
 * Den orange "KØB NU" knap som vises i bunden på CheckSizes-steppet.
 *
 */

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BuyButton(
    onClick: () -> Unit
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 40.dp)
        .padding(bottom = 30.dp)
    ) {
        TextButton(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFFE87B3F)
            ),
            shape = RoundedCornerShape(50)

        ) {
            Text(
                color = Color.White,
                fontSize = 25.sp,
                text =  "KØB NU"
            )
        }
    }
}
