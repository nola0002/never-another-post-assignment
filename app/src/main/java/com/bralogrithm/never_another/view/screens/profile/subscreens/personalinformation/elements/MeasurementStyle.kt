package com.bralogrithm.never_another.view.screens.profile.subscreens.personalinformation.elements

/*
 * Lavet af Johanne
 *
 * Enkelt felt med et kropsmål - ikon til venstre, titel + værdi i midten
 * og et "edit"-ikon til højre der signalerer at målet kan redigeres.
 * Spejler PersonalStyle, men bruges til MeasurementItem i stedet for InfoItem.
 *
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun MeasurementStyle(
    title: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(Color(0xFFF2F2F2))
            .padding(7.dp)
            .width(325.dp)
    ) {
        // Ikon i venstre side - kommer ind via parameter for at matche typen af mål.
        Column(
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.padding(end = 12.dp)
            )
        }
        // Midten viser navnet på målet (lille tekst) og selve værdien under.
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraLight,
                fontFamily = NohemiFontFamily
            )
            Text(
                text = value,
                fontFamily = NohemiFontFamily)

        }
        // Edit-ikon i højre side som visuel cue til at målet kan redigeres.
        Icon(
            imageVector = Icons.Outlined.Edit,
            contentDescription = null,
            modifier = Modifier.padding(end = 12.dp)
        )
    }
}
