package com.bralogrithm.never_another.view.screens.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.view.components.NavigationBarBottom
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
                        .padding(innerPadding)
                ) {

                    TextButton(
                        onClick = { videoFlowOnGoing = true }
                    ) {
                        Text("Start Video flow")
                    }

                    TextButton(
                        onClick = { textFlowOnGoing = true }
                    ) {
                        Text("Start Text Flow")
                    }

                }
            }
        }

    }
}