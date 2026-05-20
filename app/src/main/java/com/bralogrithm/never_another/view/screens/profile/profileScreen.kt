package com.bralogrithm.never_another.view.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.bralogrithm.never_another.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.view.components.NavigationBarBottom
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import com.bralogrithm.never_another.model.InfoItem

@Composable
fun ProfileScreen(
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
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            ProfileHeader()
            InfoSection(
                items = listOf(
                    InfoItem("FULDE NAVN", "Henriette Jensen Andersen"),
                    InfoItem("ADRESSE", "Københavnervej 3, 2500 Valby"),
                    InfoItem("E-EMAIL", "jensen.carla2500@gmail.com")
                ),
            )
            ActionButtons(
                actions = listOf("MINE OPLYSNINGER", "EFTER PLEJE", "ORDER STATUS", "FAQ"),
                onAction = {},
            )


        }
    }
}

@Composable
fun ProfileHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profil picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape),
        )

        Text(
            text = "MIN PROFIL",
            fontSize = 45.sp,
            fontWeight = Bold
        )

    }
}

@Composable
fun InfoSection(
    items: List<InfoItem>,
    modifier: Modifier = Modifier,) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp, horizontal = 40.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Personlige oplysninger"
        )
        items.forEach { item ->
            InfoStyle(title = item.title, value = item.value)
        }

        SimpleLine()

    }

}


@Composable
fun SimpleLine() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 100.dp, vertical = 50.dp),

        thickness = 1.dp,
        color = Color.Black
    )
} // https://claude.ai/share/5fe2c205-63bb-4bed-bf95-902bb2e068f6

    /*
       Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorite"
            )
            Infobox("hej", "hello")
     */



@Composable
fun InfoStyle(
    title: String,
            value: String,
            modifier: Modifier = Modifier,) {
    Column(
        modifier = modifier
            .background(Color(0xFFF2F2F2))
            .padding(2.dp)
    ) {
        Text(text = title, fontWeight = FontWeight.Thin)
        Text(text = value, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun ActionButtons(
    actions: List<String>,
    onAction: (String) -> Unit,
    modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            actions.forEach { label ->
                Button(onClick = { onAction(label) }) {
                    Text(text = label)
                }
            }
        }
    }




