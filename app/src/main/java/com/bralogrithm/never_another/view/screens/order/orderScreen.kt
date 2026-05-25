package com.bralogrithm.never_another.view.screens.order

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.ui.theme.Black
import com.bralogrithm.never_another.view.components.NavigationBarBottom
import com.bralogrithm.never_another.view.screens.order.elements.SelectionCard
import com.bralogrithm.never_another.view.screens.order.subscreens.videoguides.TextFlowScreens
import com.bralogrithm.never_another.view.screens.order.subscreens.videoguides.VideoFlowScreens

@Composable
fun MyBraScreen(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit
) {

    var videoFlowOnGoing by remember { mutableStateOf(false) }
    var textFlowOnGoing by remember { mutableStateOf(false) }

    when {
        videoFlowOnGoing -> VideoFlowScreens({ videoFlowOnGoing = false })
        textFlowOnGoing -> TextFlowScreens({ textFlowOnGoing = false })
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
                    Text(
                        style = MaterialTheme.typography.titleLarge,
                        color = Black,
                        text = "LAV DIN BH"
                    )
                    Text(
                        style = MaterialTheme.typography.headlineSmall,
                        color = Black,
                        text = "Har du prøvet at måle før?"
                    )
                    Spacer(modifier = Modifier
                        .height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        SelectionCard(
                            onClick = { videoFlowOnGoing = true },
                            inverted = true,
                            headline = "NEJ",
                            text = "Du vil se alle vores målingsvideoer"
                        )

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