package com.bralogrithm.never_another.view.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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

    Scaffold(
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
            Text("This is the Home Screen")
        }
    }

}