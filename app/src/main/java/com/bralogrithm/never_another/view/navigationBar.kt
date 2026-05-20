package com.bralogrithm.never_another.view

import com.bralogrithm.never_another.model.Screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun NavigationBarBottom(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit
) {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Hjem
            NavigationBarElement(
                navigateTo = { onScreenClick(Screen.Home)},
                text = "Hjem"
            )

            // Udforsk
            NavigationBarElement(
                navigateTo = { onScreenClick(Screen.Explore) },
                text = "Udforsk"
            )

            // MinBH
            NavigationBarElement(
                navigateTo = { onScreenClick(Screen.MyBra) },
                text = "MinBH"
            )


            // Profil
            NavigationBarElement(
                navigateTo = { onScreenClick(Screen.Profile) },
                text = "Profil"
            )
        }
    }
}

