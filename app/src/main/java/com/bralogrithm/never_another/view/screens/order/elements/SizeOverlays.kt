package com.bralogrithm.never_another.view.screens.order.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bralogrithm.never_another.model.Flows
import kotlinx.coroutines.flow.Flow

@Composable
fun Overlay(
    onContinue: () -> Unit,
    step: Flows
) {
    ContinueButton(onClick = onContinue)
    Text(
        color = Color.White,
        text = "${step}"
    )
}