package com.bralogrithm.never_another.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class TrustPilotCardInfo(
    val name: String,
    val date: String,
    val stars: Int,
    val review: String
)

val trustPilotCards = listOf(
    TrustPilotCardInfo(
        name = "Karen Sørensen",
        date = "1. april 2026",
        stars = 5,
        review = "TUSIND TAK FOR ET ENESTÅENDE DYGTIGT DESIGN ... JEG ER SÅ TILFREDS & GLAD !"
    ),
    TrustPilotCardInfo(
        name = "Susanne Jensen",
        date = "24. februar 2026",
        stars = 5,
        review = "Fremragende bh, Man mærker ikke at man har BH på. "
    ),
    TrustPilotCardInfo(
        name = "Susanne Jensen",
        date = "24. februar 2026",
        stars = 5,
        review = "Der er en rigtig god vejledning i forbindelse med bestilling. Og slutproduktet lever 100% op til forventningerne. En super behagelig BH."
    )
)



