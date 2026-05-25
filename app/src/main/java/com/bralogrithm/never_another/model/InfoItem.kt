package com.bralogrithm.never_another.model

import androidx.compose.ui.graphics.vector.ImageVector

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