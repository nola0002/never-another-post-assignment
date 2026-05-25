package com.bralogrithm.never_another.view.components

import androidx.compose.foundation.background
import com.bralogrithm.never_another.model.Screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.R


@Composable
fun NavigationBarBottom(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit
) {
    Row(
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(36.dp),
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .width(293.dp)
            .height(60.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(36.dp))
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Hjem
        NavigationBarElement(
            iconResId = R.drawable.home_svg,
            text = "Hjem",
            isSelected = selectedScreen == Screen.Home,
            onClick = { onScreenClick(Screen.Home) }
        )

        // Udforsk
        NavigationBarElement(
            iconResId = R.drawable.explore_svg,
            text = "Udforsk",
            isSelected = selectedScreen == Screen.Explore,
            onClick = { onScreenClick(Screen.Explore) }
        )

        // MinBH
        NavigationBarElement(
            iconResId = R.drawable.bra_svg,
            text = "MinBH",
            isSelected = selectedScreen == Screen.MyBra,
            onClick = { onScreenClick(Screen.MyBra) }
        )


        // Profil
        NavigationBarElement(
            iconResId = R.drawable.profile_svg,
            text = "Profil",
            isSelected = selectedScreen == Screen.Profile,
            onClick = { onScreenClick(Screen.Profile) }
        )
    }
}
