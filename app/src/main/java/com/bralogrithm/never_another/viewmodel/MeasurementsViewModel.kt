package com.bralogrithm.never_another.viewmodel

/*
 * Lavet af Noah
 *
 * ViewModel der validerer brugerens indtastede mål i overlays under ordreflowet.
 * Hver funktion trimmer input, forsøger at parse til Int og tjekker om det
 * ligger i et realistisk interval for det pågældende mål.
 *
 */

import androidx.lifecycle.ViewModel

class MeasurementsViewModel : ViewModel() {
    // Øvre brystmål - typisk interval for målgruppen.
    fun isUpperCircumferenceValid(inputText: String): Boolean {
        val trimmedText = inputText.trim()
        val parsedValue: Int = trimmedText.toIntOrNull() ?: return false
        return parsedValue in 77..113
    }

    // Nedre brystmål (underbryst) - skal være mindre end øvre, men valideres her bare som interval.
    fun isLowerCircumferenceValid(inputText: String): Boolean {
        val trimmedText = inputText.trim()
        val parsedValue: Int = trimmedText.toIntOrNull() ?: return false
        return parsedValue in 65..100
    }

    // Bryst spænd - mindre tal end de to omkredse.
    fun isBreastSpanValid(inputText: String): Boolean {
        val trimmedText = inputText.trim()
        val parsedValue: Int = trimmedText.toIntOrNull() ?: return false
        return parsedValue in 0..40
    }

    // Bryst højde - samme interval som spændet for nu.
    fun isHeightValid(inputText: String): Boolean {
        val trimmedText = inputText.trim()
        val parsedValue: Int = trimmedText.toIntOrNull() ?: return false
        return parsedValue in 0..40
    }

}