package com.bralogrithm.never_another.view.screens.explore.elements

/*
 * Lavet af Noah
 *
 * Statisk tekstblok i bunden af ExploreScreen der forklarer leveringstiden
 * og hvorfor den er længere end fast fashion.
 *
 */

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun DeliveryTimeTexts(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Text(
            text = "Leveringstid",
            fontFamily = NohemiFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = "Vi leverer din bh inden for 6 uger.\n" +
                    "Det er længere end fast fashion, og det er meningen. ",
            fontFamily = NohemiFontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp

        )

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "Det er ventetiden værd. Det lover vi.",
            fontFamily = NohemiFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Din bh findes ikke, før du bestiller den. Når du trykker på knappen, går vi i gang med at lave præcis din.",
            fontFamily = NohemiFontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp
        )
    }
}