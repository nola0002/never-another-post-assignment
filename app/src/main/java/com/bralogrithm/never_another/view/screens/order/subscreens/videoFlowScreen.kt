package com.bralogrithm.never_another.view.screens.order.subscreens

/*
 * Lavet af Sylvester
 *
 * Video-flowet som vises hvis brugeren ikke har målt før og skal guides af videoer.
 * Bruger FlowViewModel hostet af MainActivity til at hente step, overskrift og video,
 * så denne skærm kun står for at vise indholdet.
 *
 */

import androidx.compose.foundation.layout.Box
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
import com.bralogrithm.never_another.model.Flow

import com.bralogrithm.never_another.view.screens.order.elements.BuyButton
import com.bralogrithm.never_another.view.screens.order.elements.ContinueButton
import com.bralogrithm.never_another.view.screens.order.elements.OrderStatusButton
import com.bralogrithm.never_another.view.screens.order.elements.ProgessBar
import com.bralogrithm.never_another.view.screens.order.elements.Overlay
import com.bralogrithm.never_another.view.screens.order.elements.VideoPlayer
import com.bralogrithm.never_another.viewmodel.FlowViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoFlowScreens(
    onClose: () -> Unit,
    onGoToOrderStatus: () -> Unit,
    flowViewModel: FlowViewModel
) {

    // Henter step + om der skal vises video fra ViewModel, så denne skærm kun renderer.
    val step = flowViewModel.currentStep
    val hasVideo = flowViewModel.currentStepHasMedia

    Scaffold(
        containerColor = if (hasVideo) Color.Black else Color.White, // sort baggrund når videoen kører
        topBar = {
            ProgessBar(flowViewModel.steps.size, flowViewModel.currentPage, flowViewModel::lastFlow, onClose)
        },
        bottomBar = {
            // Vælger bundknap ud fra hvilket step vi er på - køb, ordrestatus eller normalt fortsæt.
            when (step) {
                Flow.CheckSizes -> BuyButton(onClick = flowViewModel::onContinueClicked)
                Flow.OrdreConfirmed -> OrderStatusButton(onClick = onGoToOrderStatus)
                else -> ContinueButton(onClick = flowViewModel::onContinueClicked)
            }
        }

    ) { innerPadding ->

        // Hvis steppet skal vise en video afspilles den med overskrift over,
        // ellers vises en af de tre faste subscreens (intro/check/confirmed).
        if (hasVideo) {

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            ) {

                VideoPlayer(rawResId = flowViewModel.videoForStep(step))

                Text(
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    text = flowViewModel.headerForStep(step),
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
                        selectedBraColor = flowViewModel.selectedBraColor,
                        onToggleColor = flowViewModel::toggleBraColor,
                        measurements = flowViewModel.measurements,
                        price = flowViewModel.price
                    )
                    Flow.OrdreConfirmed -> OrdreConfirmedScreen(
                        orderNumber = flowViewModel.orderNumber,
                        customerName = flowViewModel.customerName,
                        customerAddressLine1 = flowViewModel.customerAddressLine1,
                        customerAddressLine2 = flowViewModel.customerAddressLine2
                    )
                    else -> Unit
                }
            }
        }
    }

    // Bottom sheet til at indtaste målet for det aktuelle step.
    if (flowViewModel.showOverlay) {
        ModalBottomSheet(
            onDismissRequest = flowViewModel::closeOverlay,
            containerColor = Color.Black
        ) {
            when (step) {
                Flow.UpperSize, Flow.UnderSize, Flow.BreastHeight, Flow.BreastSize -> Overlay(
                    onContinue = { flowViewModel.onOverlayContinueClicked() },
                    header = flowViewModel.headerForStep(step),
                    value = flowViewModel.valueForStep(step),
                    onValueChange = { v -> flowViewModel.setValueForStep(step, v) },
                    error = flowViewModel.measurementError
                )
                else -> Unit
            }
        }
    }
}
