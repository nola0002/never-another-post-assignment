package com.bralogrithm.never_another.view.screens.order.subscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.model.Flow

import com.bralogrithm.never_another.view.screens.order.elements.BuyButton
import com.bralogrithm.never_another.view.screens.order.elements.ContinueButton
import com.bralogrithm.never_another.view.screens.order.elements.OrderStatusButton
import com.bralogrithm.never_another.view.screens.order.elements.ProgessBar
import com.bralogrithm.never_another.view.screens.order.elements.Overlay
import com.bralogrithm.never_another.view.screens.order.elements.VideoPlayer
import com.bralogrithm.never_another.view.screens.order.elements.convertStepToHeader
import com.bralogrithm.never_another.viewmodel.FlowViewModel

fun convertStepToVideo(step: Flow): Int {
    return when (step) {
        Flow.UpperSize -> R.raw.upper
        Flow.UnderSize -> R.raw.under
        Flow.BreastSize -> R.raw.size
        Flow.BreastHeight -> R.raw.height
        else -> R.raw.upper
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoFlowScreens(
    onClose: () -> Unit,
    onGoToOrderStatus: () -> Unit,
    vm: FlowViewModel = viewModel()
) {

    val step = vm.steps[vm.currentPage]
    val hasVideo = step !in setOf(Flow.Intro, Flow.CheckSizes, Flow.OrdreConfirmed)

    Scaffold(
        containerColor = if (hasVideo) Color.Black else Color.White,
        topBar = {
            ProgessBar(vm.steps.size, vm.currentPage, vm::lastFlow, onClose)
        },
        bottomBar = {
            when (step) {
                Flow.CheckSizes -> BuyButton(onClick = vm::onContinueClicked)
                Flow.OrdreConfirmed -> OrderStatusButton(onClick = onGoToOrderStatus)
                else -> ContinueButton(onClick = vm::onContinueClicked)
            }
        }

    ) { innerPadding ->

        if (hasVideo) {

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            ) {

                VideoPlayer(rawResId = convertStepToVideo(step))

                Text(
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    text = convertStepToHeader(step.toString()),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)
                )

            }

        } else {

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            ) {

                when (step) {
                    Flow.Intro -> IntroScreen()
                    Flow.CheckSizes -> CheckSizesScreen(
                        selectedBraColor = vm.selectedBraColor,
                        onToggleColor = vm::toggleBraColor,
                        measurements = vm.measurements,
                        price = vm.price
                    )
                    Flow.OrdreConfirmed -> OrdreConfirmedScreen(
                        orderNumber = vm.orderNumber,
                        customerName = vm.customerName,
                        customerAddressLine1 = vm.customerAddressLine1,
                        customerAddressLine2 = vm.customerAddressLine2
                    )
                    else -> Unit
                }

            }

        }

    }

    if (vm.showOverlay) {
        ModalBottomSheet(
            onDismissRequest = vm::closeOverlay,
            containerColor = Color.Black
        ) {
            when (step) {
                Flow.UpperSize, Flow.UnderSize, Flow.BreastHeight, Flow.BreastSize -> Overlay(
                    onContinue = vm::nextFlow,
                    step = step,
                    type = "Video",
                    value = vm.valueForStep(step),
                    onValueChange = { v -> vm.setValueForStep(step, v) }
                )
                else -> Unit
            }
        }
    }

}
