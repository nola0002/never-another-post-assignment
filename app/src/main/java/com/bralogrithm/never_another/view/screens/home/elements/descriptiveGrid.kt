package com.bralogrithm.never_another.view.screens.home.elements

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.ContentCut
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun DescriptiveGrid(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray,)
    ) {
        Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
            DescriptiveItem(
                modifier = Modifier.weight(1f),
                icon = { Icon(Icons.Default.Fingerprint, null, Modifier.size(48.dp)) },
                subtitle = "Skabt kun til din krop"
            )
            VerticalDivider(color = Color.Gray, thickness = 1.dp)
            DescriptiveItem(
                modifier = Modifier.weight(1f),
                icon = { Icon(Icons.Default.LocalShipping, null, Modifier.size(48.dp)) },
                subtitle = "Fragt er altid inkluderet"
            )
        }
        HorizontalDivider(color = Color.Gray, thickness = 1.dp)
        Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
            DescriptiveItem(
                modifier = Modifier.weight(1f),
                icon = { Icon(Icons.Default.ContentCut, null, Modifier.size(48.dp)) },
                subtitle = "Digitalt skrædderi"
            )
            VerticalDivider(color = Color.Gray, thickness = 1.dp)
            DescriptiveItem(
                modifier = Modifier.weight(1f),
                icon = { Icon(Icons.Default.Autorenew, null, Modifier.size(48.dp)) },
                subtitle = "Pasform-garanti"
            )
        }
    }
}

@Composable
fun DescriptiveItem(
    modifier: Modifier = Modifier,
    title: String? = null,
    icon: (@Composable () -> Unit)? = null,
    subtitle: String
) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (title != null) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 48.sp,
                    fontFamily = NohemiFontFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )
        }
        icon?.invoke()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = subtitle,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = NohemiFontFamily,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            )
        )
    }
}
