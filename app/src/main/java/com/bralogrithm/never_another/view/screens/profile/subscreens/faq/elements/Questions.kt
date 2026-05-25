package com.bralogrithm.never_another.view.screens.profile.subscreens.faq.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.model.Question
import kotlin.collections.forEach

@Composable
fun Questions(
    question: List<Question>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        question.forEach { question ->
            QuestionStyle(
                title = question.title,
                answer = question.answer
            )
        }
    }
}
