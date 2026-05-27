package com.bralogrithm.never_another.view.screens.order

/*
 * Lavet af Sylvester
 *
 * Hoved skærmen til order flow.
 *
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.ui.theme.Black
import com.bralogrithm.never_another.view.components.NavigationBarBottom
import com.bralogrithm.never_another.view.screens.order.elements.SelectionCard
import com.bralogrithm.never_another.view.screens.order.subscreens.TextFlowScreens
import com.bralogrithm.never_another.view.screens.order.subscreens.VideoFlowScreens

@Composable
fun MyBraScreen(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit,
    onGoToOrderStatus: () -> Unit
) {

    var videoFlowOnGoing by remember { mutableStateOf(false) }
    var textFlowOnGoing by remember { mutableStateOf(false) }

    when {
        videoFlowOnGoing -> VideoFlowScreens(
            onClose = { videoFlowOnGoing = false },
            onGoToOrderStatus = onGoToOrderStatus
        )
        textFlowOnGoing -> TextFlowScreens(
            onClose = { textFlowOnGoing = false },
            onGoToOrderStatus = onGoToOrderStatus
        )
        else -> {
            Scaffold(
                bottomBar = {
                    NavigationBarBottom(
                        selectedScreen = selectedScreen,
                        onScreenClick = onScreenClick
                    )
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                            top = innerPadding.calculateTopPadding(),
                            end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
                            bottom = 0.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {

                    Spacer(modifier = Modifier
                        .height(10.dp))

                    Text(
                        style = MaterialTheme.typography.titleLarge,
                        color = Black,
                        text = "HAR DU PRØVET AT MÅLE FØR?",
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier
                        .height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        SelectionCard(
                            onClick = { videoFlowOnGoing = true },
                            inverted = true,
                            headline = "NEJ",
                            text = "Du vil se alle vores målingsvideoer"
                        )

                        Spacer(modifier = Modifier.width(15.dp))

                        SelectionCard(
                            onClick = { textFlowOnGoing = true },
                            inverted = false,
                            headline = "JA",
                            text = "Du vil ikke se vores målingsvideoer"
                        )
                    }



                }
            }
        }

    }
}