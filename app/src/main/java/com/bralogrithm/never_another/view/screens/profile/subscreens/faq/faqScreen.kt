package com.bralogrithm.never_another.view.screens.profile.subscreens.faq

/*
 * Lavet af Johanne
 *
 * Hoved skærmen til FAQ-undersiden under profilen.
 * Viser en header med tilbage-pil og listen af spørgsmål fra modellen.
 *
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bralogrithm.never_another.model.questionlist
import com.bralogrithm.never_another.view.screens.profile.subscreens.faq.elements.FaqHeader
import com.bralogrithm.never_another.view.screens.profile.subscreens.faq.elements.Questions

@Composable
fun FaqScreen(
    onBackClick: () -> Unit
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
            // Header med tilbage-pil og titlen "FAQ".
            FaqHeader(onBackClick = onBackClick)

            // Render spørgsmålslisten fra modellen i model/questionlist.kt.
            Questions(questionlist)
        }
    }
}








