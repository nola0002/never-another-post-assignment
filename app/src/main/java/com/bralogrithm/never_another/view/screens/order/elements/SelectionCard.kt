package com.bralogrithm.never_another.view.screens.order.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Claude sonnet 4.6 har hjulpet med farver og hvordan de skulle sættes op :)

fun convertInvertedToColors(inverted: Boolean): Color {
    return if (!inverted) Color(0xFF4A4A4A) else Color(0xFFF0F0F0)
}

fun convertInvertedToTextColor(inverted: Boolean): Color {
    return if (!inverted) Color.White else Color(0xFF4A4A4A)
}

@Composable
fun SelectionCard(
    onClick: () -> Unit,
    inverted: Boolean,
    headline: String,
    text: String
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = convertInvertedToColors(inverted)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        onClick = onClick, // var { onClick } før — det kaldte den ikke
        modifier = Modifier
            .width(160.dp)
            .height(140.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = headline,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = convertInvertedToTextColor(inverted),
                textDecoration = TextDecoration.Underline
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = text,
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic,
                color = convertInvertedToTextColor(inverted).copy(alpha = 0.75f),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
    }
}