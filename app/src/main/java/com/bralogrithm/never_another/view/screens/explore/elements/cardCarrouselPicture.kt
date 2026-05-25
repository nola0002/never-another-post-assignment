package com.bralogrithm.never_another.view.screens.explore.elements

import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.bralogrithm.never_another.model.BraCarrouselPicture
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.model.ExploreCardSectionText
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun CardCarrouselPicture(
    listOfCardCarrouselPictures: List<BraCarrouselPicture>,
    selectedCarrouselPicture: Int,
    carrouselBackButtonClick: () -> Unit,
    carrouselForwardButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(315.dp)
            .height(315.dp)
    ) {
        Image(
            painter = painterResource(listOfCardCarrouselPictures[selectedCarrouselPicture].pictureId),
            contentDescription = "NeverAnother Branding and a picture with 3D knitted in one piece",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )

        ButtonCardSection(
            image = R.drawable.backlogocardsection,
            contentDescription = "Back logo for card Carrousel",
            onClick = carrouselBackButtonClick,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = (-14).dp)// gør at den stikker ud fra billedet
                .zIndex(1f)
        )


        // Usynlig knap der gør feltet større at klikke på
        TransparentButtonCardSection(
            onClick = carrouselBackButtonClick,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = (-50).dp)
                .zIndex(1f)
        )

        ButtonCardSection(
            image = R.drawable.forwardlogocardsection,
            contentDescription = "Forward logo for card carrousel",
            onClick = carrouselForwardButtonClick,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = 14.dp)// gør at den stikker ud fra billedet
                .zIndex(1f)
        )


        // Usynlig knap der gør feltet større at klikke på
        TransparentButtonCardSection(
            onClick = carrouselForwardButtonClick,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = (50).dp)
                .zIndex(1f)
        )


    }
}



