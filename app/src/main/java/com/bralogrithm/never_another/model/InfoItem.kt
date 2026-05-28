package com.bralogrithm.never_another.model

import androidx.compose.ui.graphics.vector.ImageVector

/*
 * Lavet af Johanne
 *
 * Data klasser til Oplysninger-skærmen.
 *
 * InfoItem bruges af PersonalSection til personlige oplysninger (navn, adresse, email).
 * MeasurementItem bruges af YourMeasurement til kropsmål (øvre/nedre bryst, spænd, højde).
 * Begge har samme struktur, men er adskilt for at gøre det tydeligt hvad de bruges til.
 *
 */

data class InfoItem(
    val title: String,
    val value: String,
    val icon: ImageVector
)

data class MeasurementItem(
    val title: String,
    val value: String,
    val icon: ImageVector
)