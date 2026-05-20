package com.bralogrithm.never_another.view.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeDefaults
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.view.components.NavigationBarBottom
import com.bralogrithm.never_another.ui.theme.Black
import com.bralogrithm.never_another.ui.theme.White

@Composable
fun HomeScreen(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit
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
                .padding(innerPadding)
        ) {

            // ADD WEIGHT HERE: This tells Compose not to re-calculate
            // the height of the image while the text moves.
            Box(modifier = Modifier.weight(1f)) {
                ImageArea()
            }
        }
    }
}



@Composable
fun ImageArea() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.landing_page_image),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        ) {
            Text(
                text = "Digitalt ".uppercase(),
                style = MaterialTheme.typography.titleLarge,
                color = Black
            )
            Text(
                text = "Skrædderet".uppercase(),
                style = MaterialTheme.typography.titleLarge,
                color = White
            )
        }
    }
}