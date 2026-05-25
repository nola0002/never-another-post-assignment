package com.bralogrithm.never_another.view.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.model.InfoItem
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.model.SubScreensProfile
import com.bralogrithm.never_another.model.labels
import com.bralogrithm.never_another.view.components.NavigationBarBottom
import com.bralogrithm.never_another.view.screens.profile.elements.ActionButtons
import com.bralogrithm.never_another.view.screens.profile.elements.InfoSection
import com.bralogrithm.never_another.view.screens.profile.elements.ProfileHeader

@Composable
fun ProfileScreen(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit,
    onAction: (SubScreensProfile) -> Unit,
) {
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
                )
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            ProfileHeader()
            InfoSection(
                items = listOf(
                    InfoItem("FULDE NAVN", "Henriette Jensen Andersen", Icons.Outlined.Sell),
                    InfoItem("ADRESSE", "Københavnervej 3, 2500 Valby", Icons.Outlined.Inventory2),
                    InfoItem("E-EMAIL", "jensen.carla2500@gmail.com", Icons.Default.MailOutline)
                ),
            )
            ActionButtons(
                labels = labels,
                onAction = onAction,
            )
        }
    }
}














