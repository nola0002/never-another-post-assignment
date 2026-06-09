package com.bralogrithm.never_another.view.screens.order.subscreens

/*
 * Lavet af Sylvester
 *
 * Tekst-flowet som vises hvis brugeren har målt før og bare vil have billeder + felter.
 * Bruger FlowViewModel hostet af MainActivity til at læse step, overskrift, billede og værdier,
 * så denne skærm ikke selv står for state.
 *
 */

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.model.Flow

import com.bralogrithm.never_another.view.screens.order.elements.BuyButton
import com.bralogrithm.never_another.view.screens.order.elements.ContinueButton
import com.bralogrithm.never_another.view.screens.order.elements.OrderStatusButton
import com.bralogrithm.never_another.view.screens.order.elements.ProgessBar
import com.bralogrithm.never_another.view.screens.order.elements.Overlay
import com.bralogrithm.never_another.viewmodel.FlowViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFlowScreens(
    onClose: () -> Unit,
    onGoToOrderStatus: () -> Unit,
    flowViewModel: FlowViewModel
) {

    // Henter step + om der skal vises billede fra ViewModel, så denne skærm kun renderer.
    val step = flowViewModel.currentStep
    val hasImage = flowViewModel.currentStepHasMedia

    Scaffold(
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
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally)
        {

            // Hvis steppet skal vise et billede vises overskrift + drawable,
            // ellers vises en af de tre faste subscreens (intro/check/confirmed).
            if (hasImage) {

                Text(
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                    text = flowViewModel.headerForStep(step),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)
                )

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(flowViewModel.imageForStep(step)),
                        contentDescription = flowViewModel.headerForStep(step),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier
                    .height(20.dp))

            } else {

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
