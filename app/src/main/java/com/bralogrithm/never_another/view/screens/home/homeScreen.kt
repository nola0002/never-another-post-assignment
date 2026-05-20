package com.bralogrithm.never_another.view.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.view.components.NavigationBarBottom

@Composable
fun HomeScreen(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit

){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("This is the Home Screen")

        NavigationBarBottom(
            selectedScreen = selectedScreen,
            onScreenClick = onScreenClick
        )

    }
}