package com.bralogrithm.never_another.view.screens.order.elements

/*
 * Lavet af Sylvester
 *
 * Overlay'et som vises i bottom sheet'et når brugeren skal indtaste et mål.
 * Modtager header som string - selve mapningen fra step til overskrift ligger i FlowViewModel,
 * så denne komponent kun viser det den får ind.
 *
 */

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

@Composable
fun Overlay(
    onContinue: () -> Unit,
    header: String,
    value: String,
    onValueChange: (String) -> Unit,
    error: String? = null
) {
    ContinueButton(onClick = onContinue)

    Column() {
        Text(
            color = Color.White,
            text = header,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier
            .height(10.dp))


        // Fejlbesked vises kun når der er en - Noah
        if (error != null) {
            Spacer(modifier = Modifier
                .height(8.dp))

            Text(
                text = error,
                color = Color(0xFFFF5A5F),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }

        Spacer(modifier = Modifier
            .height(10.dp))

        TextField(
            value = value,
            onValueChange = onValueChange,
            isError = error != null,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),

        )

    }


}
