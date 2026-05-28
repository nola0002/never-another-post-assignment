package com.bralogrithm.never_another.view.screens.profile.subscreens.personalinformation

/*
 * Lavet af Johanne
 *
 * Hoved skærmen til "Oplysninger"-undersiden under profilen.
 * Viser header, personlige oplysninger og brugerens mål (som kommer ind via parametre).
 *
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bralogrithm.never_another.model.InfoItem
import com.bralogrithm.never_another.model.MeasurementItem
import com.bralogrithm.never_another.view.screens.profile.subscreens.personalinformation.elements.InformationHeader
import com.bralogrithm.never_another.view.screens.profile.subscreens.personalinformation.elements.PersonalSection
import com.bralogrithm.never_another.view.screens.profile.subscreens.personalinformation.elements.YourMeasurement
import org.w3c.dom.Text

@Composable
fun InformationScreen (
    onBackClick: () -> Unit,
    upperCircumference: String,
    lowerCircumference: String,
    breastSpan: String,
    breastHeight: String
) {
    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            // Header med tilbage-pil, profilbillede og "skift billede"-tekst.
            InformationHeader(onBackClick = onBackClick)

            // Personlige oplysninger som navn, adresse og email - hardcoded indtil
            // vi har en rigtig brugerprofil at læse fra.
            PersonalSection(
                items = listOf(
                    InfoItem("FULDE NAVN", "Henriette Jensen Andersen", Icons.Outlined.Sell),
                    InfoItem("ADRESSE", "Københavnervej 3, 2500 Valby", Icons.Outlined.Inventory2),
                    InfoItem("E-EMAIL", "jensen.carla2500@gmail.com", Icons.Default.MailOutline)
                ),
            )


            // Brugerens mål kommer ind som parametre fra MainActivity/FlowViewModel,
            // så de viser de seneste indtastede værdier fra ordreflowet.
            YourMeasurement(
                measurement = listOf(
                    MeasurementItem("ØVRE BRYST MÅL", upperCircumference, Icons.Outlined.ContentPaste),
                    MeasurementItem("NEDRE BRYST MÅL", lowerCircumference, Icons.Outlined.ContentPaste),
                    MeasurementItem("BRYST SPÆND", breastSpan, Icons.Outlined.ContentPaste),
                    MeasurementItem("BRYST HØJDE", breastHeight, Icons.Outlined.ContentPaste)

                )

            )

        }
    }
}






