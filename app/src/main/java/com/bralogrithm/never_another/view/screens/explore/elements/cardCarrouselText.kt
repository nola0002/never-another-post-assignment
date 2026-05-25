package com.bralogrithm.never_another.view.screens.explore.elements

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.model.ExploreCardSectionText
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun CardCarrouselText(
    listOfCardSectionText: List<ExploreCardSectionText>,
    selectedCarrouselText: Int,
    carrouselBackButtonClick: () -> Unit,
    carrouselForwardButtonClick: () -> Unit
) {
    val shape = RoundedCornerShape(16.dp)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ButtonCardSection(
            image = R.drawable.backlogocardsection,
            contentDescription = "Back logo for card Carrousel",
            onClick = carrouselBackButtonClick,
        )

        Card(
            modifier = Modifier
                .height(246.dp)
                .width(313.dp)
                .padding(vertical = 4.dp)
                .background(Color.White)
                .border(1.dp, Color.Black, shape),
            shape = shape,
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    TransparentButtonCardSection(
                        onClick = carrouselBackButtonClick
                    )



                    Column(
                        modifier = Modifier
                            .height(180.dp)
                            .width(240.dp)
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(top = 16.dp),
                            text = listOfCardSectionText[selectedCarrouselText].thickText,
                            fontSize = 24.sp,
                            fontFamily = NohemiFontFamily,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center,
                            )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = listOfCardSectionText[selectedCarrouselText].thinText,
                            fontSize = 16.sp,
                            fontFamily = NohemiFontFamily,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center,
                        )
                    }


                    TransparentButtonCardSection(
                        onClick = carrouselForwardButtonClick
                    )

                }
            }
        }

        ButtonCardSection(
            image = R.drawable.forwardlogocardsection,
            contentDescription = "Forward logo for card carrousel",
            onClick = carrouselForwardButtonClick
        )

    }
}