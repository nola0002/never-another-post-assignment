package com.bralogrithm.never_another.viewmodel

/*
 * Lavet af Sylvester - testet af Noah.
 *
 * ViewModel er seperat fra NeverAnotherViewModel af hensyn til separation of concerns.
 * Denne ViewModel deler ikke logik eller data med NeverAnotherViewModel.
 *
 * View modellen bruges til state hosting til vores købsflow og diktere hvilken side som brugeren ser i appen.
 *  - Enkelt stående data som pris og statisk data er hardcoded i ViewModel og kommer ikke fra model.
 *
 */

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bralogrithm.never_another.model.BraColor
import com.bralogrithm.never_another.model.Flow

class FlowViewModel : ViewModel() {
    val steps = listOf(
        Flow.Intro,
        Flow.UpperSize,
        Flow.UnderSize,
        Flow.BreastHeight,
        Flow.BreastSize,
        Flow.CheckSizes,
        Flow.OrdreConfirmed
    )

    private val stepsWithoutOverlay = setOf(Flow.Intro, Flow.CheckSizes, Flow.OrdreConfirmed)

    val price = "DKK 799"

    val orderNumber = "85391"
    val customerName = "Henriette Jensen Andersen"
    val customerAddressLine1 = "Københavnervej 3"
    val customerAddressLine2 = "2500 Valby"

    var currentPage by mutableStateOf(0)
    var showOverlay by mutableStateOf(false)

    var selectedBraColor by mutableStateOf(BraColor.Black)


    fun validateMeasurement(inputText: String, minValue: Int, maxValue: Int): String? {
        val trimmedText = inputText.trim() // Fjerne mellemrum før og efter string

        if (trimmedText.isEmpty()) { // hvis feltet er submitted med tom streng
            return "Udfyld feltet" // retuner det her
        }

        val intValue: Int = trimmedText.toIntOrNull() //gemmer int værdien i en variabel
            ?: return "Skal være et tal" // hvis ikke det er en int, så returner det her.

        if (intValue < minValue || intValue > maxValue) { //hvis int værdien er mindre end mindste værdien eller større end maksimale værdien
            return "Skal være mellem $minValue og $maxValue" // Så returner det her
        }

        return inputText // Hvis det er et tal inden for min og max returner det
    }







    var upperCircumference by mutableStateOf("0")

    var lowerCircumference by mutableStateOf("0")
    var breastSpan by mutableStateOf("0")
    var breastHeight by mutableStateOf("0")

    val measurements: List<Pair<String, String>>
        get() = listOf(
            "Øvre bryst mål" to "${
                validateMeasurement(
                    inputText = upperCircumference,
                    minValue = 77,
                    maxValue = 113)
            } cm",
            "Nedre bryst mål" to "${
                validateMeasurement(
                    inputText = lowerCircumference,
                    minValue = 65,
                    maxValue = 100
                )
            } cm",
            "Bryst spænd" to "${
                validateMeasurement(
                    inputText = breastSpan,
                    minValue = 0,
                    maxValue = 40
                )
            } cm",
            "Bryst højde" to "${
                validateMeasurement(
                    inputText = breastHeight,
                    minValue = 0,
                    maxValue = 40
                )
            } cm",
        )

    fun valueForStep(step: Flow): String {
        return when (step) {
            Flow.UpperSize -> upperCircumference
            Flow.UnderSize -> lowerCircumference
            Flow.BreastHeight -> breastSpan
            Flow.BreastSize -> breastHeight
            else -> ""
        }
    }

    fun setValueForStep(step: Flow, value: String) {
        when (step) {
            Flow.UpperSize -> upperCircumference = value
            Flow.UnderSize -> lowerCircumference = value
            Flow.BreastHeight -> breastSpan = value
            Flow.BreastSize -> breastHeight = value
            else -> {}
        }
    }

    fun openOverlay() { showOverlay = true }
    fun closeOverlay() { showOverlay = false}

    fun onContinueClicked() {
        val step = steps[currentPage]
        if (step in stepsWithoutOverlay) nextFlow() else showOverlay = true
    }

    fun nextFlow() {
        if (currentPage < steps.lastIndex) currentPage++
        showOverlay = false
    }

    fun lastFlow() {
        if (currentPage != 0) currentPage--
    }

    fun toggleBraColor() {
        selectedBraColor = if (selectedBraColor == BraColor.Black) BraColor.White else BraColor.Black
    }

}
