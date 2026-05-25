package com.bralogrithm.never_another.view.screens.order.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
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
    type: String
) {
    ContinueButton(onClick = onContinue)

    Column() {
        Text(
            color = Color.White,
            text = convertStepToHeader(step.toString())
        )

    }


}