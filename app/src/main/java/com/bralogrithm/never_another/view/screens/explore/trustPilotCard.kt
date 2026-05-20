package com.bralogrithm.never_another.view.screens.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun TrustPilotCard(
    name: String,
    date: String,
    review: String
) {
    val shape = RoundedCornerShape(16.dp)

    val amountOfStars: Int = 5
    Card(
        modifier = Modifier
            .height(106.dp)
            .width(313.dp)
            .padding(vertical = 4.dp),
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xffD5D5D5)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        text = name,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        fontFamily = NohemiFontFamily,
                        fontWeight = FontWeight.Normal,
                    )
                    Spacer(modifier = Modifier
                        .height(2.dp))
                    Text(
                        modifier = Modifier,
                        text = date,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp,
                        fontFamily = NohemiFontFamily,
                        fontWeight = FontWeight.Light,
                    )
                }


                Row() {
                    if (amountOfStars == 5){
                        Image(
                            painter = painterResource(R.drawable.starfilledtrustpilot),
                            contentDescription = "A star for the trust pilot reviews",
                            modifier = Modifier
                        )
                        Image(
                            painter = painterResource(R.drawable.starfilledtrustpilot),
                            contentDescription = "A star for the trust pilot reviews",
                            modifier = Modifier
                        )
                        Image(
                            painter = painterResource(R.drawable.starfilledtrustpilot),
                            contentDescription = "A star for the trust pilot reviews",
                            modifier = Modifier
                        )
                        Image(
                            painter = painterResource(R.drawable.starfilledtrustpilot),
                            contentDescription = "A star for the trust pilot reviews",
                            modifier = Modifier
                        )
                        Image(
                            painter = painterResource(R.drawable.starfilledtrustpilot),
                            contentDescription = "A star for the trust pilot reviews",
                            modifier = Modifier
                        )

                    }
                }
            }

            Spacer(modifier = Modifier
                .height(14.dp))


            Text(
                modifier = Modifier,
                text = review,
                fontSize = 12.sp,
                fontFamily = NohemiFontFamily,
                fontWeight = FontWeight.Normal,
            )

        }
    }
}