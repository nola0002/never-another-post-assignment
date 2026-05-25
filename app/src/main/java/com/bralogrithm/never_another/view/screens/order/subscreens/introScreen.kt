package com.bralogrithm.never_another.view.screens.order.subscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.view.screens.order.elements.IntroInfoCard

@Composable
fun IntroScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "ER DU KLAR?",
            fontSize = 40.sp,
            fontWeight = FontWeight.Black,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp)
        )

        Image(
            painter = painterResource(R.drawable.landing_page_image),
            contentDescription = "Måling af bryst",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier
            .height(20.dp))

        IntroInfoCard(
            iconResId = R.drawable.tape_measure_svg,
            headline = "Målebånd",
            text = "Du skal bruge et målebånd"
        )

        IntroInfoCard(
            iconResId = R.drawable.bra_svg,
            headline = "En BH",
            text = "Tag en godt siddende BH på for at lave den mest præcise målning"
        )

    }
}
