package com.bralogrithm.never_another.view.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.bralogrithm.never_another.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.LayoutDirection
import com.bralogrithm.never_another.model.InfoItem
import com.bralogrithm.never_another.model.Label
import com.bralogrithm.never_another.model.SubScreensProfile
import com.bralogrithm.never_another.model.labels
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

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
                .size(80.dp)
                .clip(CircleShape),
        )

        Box(
            modifier = Modifier
                .height(35.dp)
        ){
            Text(
                text = "MIN PROFIL",
                fontSize = 45.sp,
                fontWeight = Medium,
                fontFamily = NohemiFontFamily
            )

            Image(
                painter = painterResource(R.drawable.brushstrokes),
                contentDescription = "Brush Stroke",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .offset(x = 180.dp, y = (-30).dp)
                    .rotate(20f)
            )
        }

    }
}

@Composable
fun InfoSection(
    items: List<InfoItem>,
    modifier: Modifier = Modifier,) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp, top = 30.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "PERSONLIGE OPLYSNINGER",
            fontWeight = Bold,
            fontSize = 20.sp,
            fontFamily = NohemiFontFamily
        )
        items.forEach { item ->
            InfoStyle(title = item.title, value = item.value, icon = item.icon)
        }



    }
    SimpleLine()

}

@Composable
fun SimpleLine() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 130.dp, vertical = 30.dp),

        thickness = 1.dp,
        color = Color.Black
    )
} // https://claude.ai/share/5fe2c205-63bb-4bed-bf95-902bb2e068f6

    /*
       Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorite"
            )

https://claude.ai/share/cd4ff895-8567-408c-9f59-55b27e1ab9fe

     */



@Composable
fun InfoStyle(
    title: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    ) {
    Row(
        modifier = modifier
            .background(Color(0xFFF2F2F2))
            .padding(7.dp)
            .width(325.dp)
    ) {
        Column(
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.padding(end = 12.dp)
            )
        }
        Column() {
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraLight,
                fontFamily = NohemiFontFamily
            )
            Text(
                text = value,
                fontFamily = NohemiFontFamily)

        }
        }


}


@Composable
fun ActionButtons(
    labels: List<Label>,
    onAction: (SubScreensProfile) -> Unit,
    modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            labels.forEach { label ->
                Button(
                    modifier = Modifier
                        .width(340.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(16.dp)) ,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF2F2F2),
                        contentColor = Color.Black
                    ),
                    onClick = { onAction(label.subScreen) }
                ) {
                    Text(
                        text = label.labelName,
                        fontFamily = NohemiFontFamily,
                        fontSize = 15.sp,
                    )
                }
            }
        }
    }




