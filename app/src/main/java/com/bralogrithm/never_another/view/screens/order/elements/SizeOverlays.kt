package com.bralogrithm.never_another.view.screens.order.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.bralogrithm.never_another.model.Flow

@Composable
fun Overlay(
    onContinue: () -> Unit,
    step: Flow,
    type: String
) {
    ContinueButton(onClick = onContinue)
    Text(
        color = Color.White,
        text = "${type} : ${step}"
    )
}