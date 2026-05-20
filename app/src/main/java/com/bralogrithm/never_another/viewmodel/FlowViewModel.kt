package com.bralogrithm.never_another.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
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

    var currentPage by mutableStateOf(0)
    var showOverlay by mutableStateOf(false)

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

}