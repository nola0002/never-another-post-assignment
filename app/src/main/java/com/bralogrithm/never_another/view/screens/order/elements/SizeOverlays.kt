package com.bralogrithm.never_another.view.screens.order.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.model.Flow

fun convertStepToHeader(
    step: String
): String {
    return when (step) {
        "UpperSize" -> "Øvre bryst mål"
        "UnderSize" -> "Nedre bryst mål"
        "BreastSize" -> "Bryst Spænd"
        "BreastHeight" -> "Bryst Højde"
        else -> "Fejl"
    }
}
@Composable
fun Overlay(
    onContinue: () -> Unit,
    step: Flow,
    type: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    ContinueButton(onClick = onContinue)

    Column() {
        Text(
            color = Color.White,
            text = convertStepToHeader(step.toString()),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier
            .height(10.dp))

        TextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),

        )

    }


}
