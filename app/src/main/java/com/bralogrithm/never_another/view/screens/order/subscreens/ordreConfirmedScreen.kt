package com.bralogrithm.never_another.view.screens.order.subscreens

/*
 * Lavet af Sylvester
 *
 * Bekræftelses-skærmen som vises efter køb. Viser ordrenummer, kundens navn og adresse
 * sammen med en loading-gif. Data kommer fra FlowViewModel.
 *
 */

import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.view.screens.order.elements.LoadingStateGif

@Composable
fun OrdreConfirmedScreen(
    orderNumber: String,
    customerName: String,
    customerAddressLine1: String,
    customerAddressLine2: String
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "ORDRE #${orderNumber}",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = customerName,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = customerAddressLine1,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = customerAddressLine2,
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier
            .height(20.dp))

        LoadingStateGif(
            rawResId = R.raw.loading_state_image,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )

        Spacer(modifier = Modifier
            .height(8.dp))

        Text(
            text = "VI SENDER DIN BH TIL STRIKNING!",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier
            .height(40.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "IMENS KAN DU\nFØLGE MED I DIN\nORDRE STATUS",
                fontSize = 36.sp,
                fontWeight = FontWeight.Black,
                color = Color.Black,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }
}
