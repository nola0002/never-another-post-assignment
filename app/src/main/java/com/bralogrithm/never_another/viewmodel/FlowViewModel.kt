package com.bralogrithm.never_another.viewmodel

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

    var upperSize by mutableStateOf("0")
    var underSize by mutableStateOf("0")
    var breastHeight by mutableStateOf("0")
    var breastSize by mutableStateOf("0")

    val measurements: List<Pair<String, String>>
        get() = listOf(
            "Øvre bryst mål" to "$upperSize cm",
            "Nedre bryst mål" to "$underSize cm",
            "Bryst spænd" to "$breastSize cm",
            "Bryst højde" to "$breastHeight cm",
        )

    fun valueForStep(step: Flow): String {
        return when (step) {
            Flow.UpperSize -> upperSize
            Flow.UnderSize -> underSize
            Flow.BreastHeight -> breastHeight
            Flow.BreastSize -> breastSize
            else -> ""
        }
    }

    fun setValueForStep(step: Flow, value: String) {
        when (step) {
            Flow.UpperSize -> upperSize = value
            Flow.UnderSize -> underSize = value
            Flow.BreastHeight -> breastHeight = value
            Flow.BreastSize -> breastSize = value
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
