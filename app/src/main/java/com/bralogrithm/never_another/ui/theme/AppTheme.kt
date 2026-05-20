package com.bralogrithm.never_another.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R

val NohemiFontFamily = FontFamily(
    Font(R.font.nohemi_thin, FontWeight.Thin),
    Font(R.font.nohemi_extralight, FontWeight.ExtraLight),
    Font(R.font.nohemi_light, FontWeight.Light),
    Font(R.font.nohemi_regular, FontWeight.Normal),
    Font(R.font.nohemi_medium, FontWeight.Medium),
    Font(R.font.nohemi_semibold, FontWeight.SemiBold),
    Font(R.font.nohemi_bold, FontWeight.Bold),
    Font(R.font.nohemi_extrabold, FontWeight.ExtraBold),
    Font(R.font.nohemi_black, FontWeight.Black)
)

val Orange = Color(0xFFF37401)
val Charcoal = Color(0xFF2A2A2C)
val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)

val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = NohemiFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 36.sp
    ),
)

@Composable
fun NeverAnotherTheme(
    content: @Composable () -> Unit
) {
    val colors = lightColorScheme(
        primary = Orange,
        secondary = Charcoal,
        background = White,
    )

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}

