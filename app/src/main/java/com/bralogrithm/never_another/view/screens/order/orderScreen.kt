package com.bralogrithm.never_another.view.screens.order

import androidx.compose.runtime.Composable
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.view.screens.order.subscreens.videoguides.FlowScreens

@Composable
fun MyBraScreen(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit

){
    /*Scaffold(
        bottomBar = {
            NavigationBarBottom(
                selectedScreen = selectedScreen,
                onScreenClick = onScreenClick
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

        }
    } */
    FlowScreens()
}