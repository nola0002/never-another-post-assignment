package com.bralogrithm.never_another.view.screens.order.subscreens.videoguides

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bralogrithm.never_another.model.Flow

import com.bralogrithm.never_another.view.screens.order.elements.ContinueButton
import com.bralogrithm.never_another.view.screens.order.elements.ProgessBar
import com.bralogrithm.never_another.view.screens.order.elements.Overlay
import com.bralogrithm.never_another.viewmodel.FlowViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFlowScreens(
    onClose: () -> Unit,
    vm: FlowViewModel = viewModel()
) {

    val step = vm.steps[vm.currentPage]

    Scaffold(
        topBar = {
            ProgessBar(vm.steps.size, vm.currentPage, vm::lastFlow, onClose)
        },
        bottomBar = {
            if (vm.currentPage == (vm.steps.size - 1)) {
                Text("Slut")
            } else {
                ContinueButton(
                    onClick = vm::onContinueClicked
                )
            }
        }

    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Text("Text flow: ${step}")
        }
    }
    if (vm.showOverlay) {
        ModalBottomSheet(
            onDismissRequest = vm::closeOverlay,
            containerColor = Color.Black
        ) {
            when (step) {
                Flow.UpperSize -> Overlay(vm::nextFlow, step, "Text")
                Flow.UnderSize -> Overlay(vm::nextFlow, step, "Text")
                Flow.BreastHeight -> Overlay(vm::nextFlow, step, "Text")
                Flow.BreastSize -> Overlay(vm::nextFlow, step, "Text")
                else -> Unit
            }
        }
    }
}