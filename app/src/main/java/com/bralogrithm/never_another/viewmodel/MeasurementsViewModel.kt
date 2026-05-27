package com.bralogrithm.never_another.viewmodel

import androidx.lifecycle.ViewModel

class MeasurementsViewModel : ViewModel() {
    fun isUpperCircumferenceValid(inputText: String): Boolean {
        val trimmedText = inputText.trim()
        val parsedValue: Int = trimmedText.toIntOrNull() ?: return false
        return parsedValue in 77..113
    }

    fun isLowerCircumferenceValid(inputText: String): Boolean {
        val trimmedText = inputText.trim()
        val parsedValue: Int = trimmedText.toIntOrNull() ?: return false
        return parsedValue in 65..100
    }

    fun isBreastSpanValid(inputText: String): Boolean {
        val trimmedText = inputText.trim()
        val parsedValue: Int = trimmedText.toIntOrNull() ?: return false
        return parsedValue in 0..40
    }

    fun isHeightValid(inputText: String): Boolean {
        val trimmedText = inputText.trim()
        val parsedValue: Int = trimmedText.toIntOrNull() ?: return false
        return parsedValue in 0..40
    }

}