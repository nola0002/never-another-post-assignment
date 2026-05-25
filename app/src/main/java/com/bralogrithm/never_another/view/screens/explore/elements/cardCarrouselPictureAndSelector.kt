package com.bralogrithm.never_another.view.screens.explore.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.model.BraCarrouselPicture
import com.bralogrithm.never_another.model.BraColor
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun CardCarrouselPictureAndSelector(
    listOfCardCarrouselPictures: List<BraCarrouselPicture>,
    selectedCarrousel: Int,
    carrouselBackButtonClick: () -> Unit,
    carrouselForwardButtonClick: () -> Unit,
    selectedColor: BraColor,
    onClickWhite: () -> Unit,
    onClickBlack: () -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardCarrouselPicture(
            listOfCardCarrouselPictures = listOfCardCarrouselPictures,
            selectedCarrouselPicture = selectedCarrousel,
            carrouselBackButtonClick = carrouselBackButtonClick,
            carrouselForwardButtonClick = carrouselForwardButtonClick
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = if (selectedColor == BraColor.White) {
                        "Farve: Hvid"
                    } else {
                        "Farve: Sort"
                    },
                    fontFamily = NohemiFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )

                Spacer(
                    modifier = Modifier
                        .height(4.dp)
                )


                Text(
                    text = "Bra no. 1",
                    fontFamily = NohemiFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {


                ColorDotCarrousel(
                    color = Color(0xffF2F1ED),
                    selected = selectedColor == BraColor.White,
                    onClick = onClickWhite
                )
                ColorDotCarrousel(
                    color = Color(0xff2A2A2C),
                    selected = selectedColor == BraColor.Black,
                    onClick = onClickBlack
                )

            }
        }
    }
}