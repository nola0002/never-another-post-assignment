package com.bralogrithm.never_another.view.screens.profile.subscreens.personalinformation.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily
import com.bralogrithm.never_another.view.components.Arrow

@Composable
fun InformationHeader(onBackClick: () -> Unit){
    Row(
        modifier = Modifier
            .padding(bottom = 15.dp, start = 35.dp, top = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Arrow(onBackClick = onBackClick)
        Text(
            text = "OPLYSNINGER",
            fontSize = 41.sp,
            fontWeight = Medium,
            fontFamily = NohemiFontFamily
        )
    }
    Image(
        painter = painterResource(R.drawable.profile),
        contentDescription = "Profil picture",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape),
    )
    Column(
        modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SKIFT BILLEDE",
            fontSize = 15.sp,
            fontWeight = Medium,
            fontFamily = NohemiFontFamily,
            textDecoration = TextDecoration.Underline
        )
    }
}