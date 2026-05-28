package com.bralogrithm.never_another.model

/*
 * Lavet af Johanne
 *
 * Data klasse til et enkelt FAQ-spørgsmål med tilhørende svar.
 * Bruges af questionlist og af QuestionStyle på FAQ-skærmen.
 *
 */

data class Question (
    val title: String,
    val answer: String
)