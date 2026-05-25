package com.bralogrithm.never_another.view.screens.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.model.BraCarrouselPicture
import com.bralogrithm.never_another.model.BraColor
import com.bralogrithm.never_another.model.ExploreCardSectionText
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.model.TrustPilotCardInfo
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily
import com.bralogrithm.never_another.view.components.NavigationBarBottom
import com.bralogrithm.never_another.view.screens.explore.elements.CardCarrouselPicture
import com.bralogrithm.never_another.view.screens.explore.elements.CardCarrouselText
import com.bralogrithm.never_another.view.screens.explore.elements.ColorDotCarrousel
import com.bralogrithm.never_another.view.screens.explore.elements.DeliveryTimeTexts
import com.bralogrithm.never_another.view.components.TextWithBrushStroke
import com.bralogrithm.never_another.view.screens.explore.elements.TrustPilotCard
import com.bralogrithm.never_another.view.components.BottomLogo
import com.bralogrithm.never_another.view.screens.explore.elements.CardCarrouselPictureAndSelector

@Composable
fun ExploreScreen(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit,
    listOfCardCarrouselPictures: List<BraCarrouselPicture>,
    selectedColor: BraColor,
    onClickWhite: () -> Unit,
    onClickBlack: () -> Unit,
    listOfCardSectionTextOne: List<ExploreCardSectionText>,
    selectedCarrousel: Int,
    carrouselBackButtonClick: () -> Unit,
    carrouselForwardButtonClick: () -> Unit,
    trustPilotCards: List<TrustPilotCardInfo>,
    listOfCardSectionTextTwo: List<ExploreCardSectionText>
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
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .height(40.dp)
            )

            TextWithBrushStroke(
                text = "Skabt til dig.\n" +
                        "Kun til dig.",
                fontSize = 52,
                fontWeight = FontWeight.Normal,
                boxHeight = 150,
                boxPaddingStart = 44,
                modifier = Modifier
                    .size(94.dp)
                    .offset(x = 208.dp, y = (54).dp)
                    .rotate(146f)
            )

            Spacer(
                modifier = Modifier
                    .height(30.dp)
            )

            CardCarrouselPictureAndSelector(
                listOfCardCarrouselPictures = listOfCardCarrouselPictures,
                selectedCarrousel = selectedCarrousel,
                carrouselBackButtonClick = carrouselBackButtonClick,
                carrouselForwardButtonClick = carrouselForwardButtonClick,
                selectedColor = selectedColor,
                onClickWhite = onClickWhite,
                onClickBlack = onClickBlack
            )

            Spacer(
                modifier = Modifier
                    .height(40.dp)
            )

            Image(
                painter = painterResource(R.drawable.knittedinonepieceexplore),
                contentDescription = "NeverAnother Branding and a picture with 3D knitted in one piece",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Spacer(
                modifier = Modifier
                    .height(50.dp)
            )

            CardCarrouselText(
                listOfCardSectionText = listOfCardSectionTextOne,
                selectedCarrouselText = selectedCarrousel,
                carrouselBackButtonClick = carrouselBackButtonClick,
                carrouselForwardButtonClick = carrouselForwardButtonClick

            )

            Spacer(
                modifier = Modifier
                    .height(50.dp)
            )

            TextWithBrushStroke(
                text = "Stol på hinanden.",
                fontSize = 40,
                fontWeight = FontWeight.Normal,
                boxHeight = 40,
                boxPaddingStart = 44,
                modifier = Modifier
                    .size(94.dp)
                    .offset(x = (-36).dp, y = (-30).dp)
                    .rotate(2f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 44.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Trustpilot.com",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = NohemiFontFamily
                )
            }

            Spacer(
                modifier = Modifier
                    .height(14.dp)
            )


            trustPilotCards.forEach { trustPilotCard ->
                TrustPilotCard(
                    name = trustPilotCard.name,
                    date = trustPilotCard.date,
                    review = trustPilotCard.review
                )
            }

            Spacer(
                modifier = Modifier
                    .height(30.dp)
            )

            Image(
                painter = painterResource(R.drawable.womansowingmachine),
                contentDescription = "Woman at the sowing machine, that is used to make the NeverAnother bra",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Spacer(
                modifier = Modifier
                    .height(40.dp)
            )

            TextWithBrushStroke(
                text = "Strikket.\n" +
                        "Ikke syet.",
                fontSize = 40,
                fontWeight = FontWeight.Normal,
                boxHeight = 80,
                boxPaddingStart = 44,
                modifier = Modifier
                    .size(88.dp)
                    .offset(x = (140).dp, y = (-10).dp)
                    .rotate(72f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 44.dp, top = 4.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Derfor føles det anderledes",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = NohemiFontFamily
                )
            }

            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )

            CardCarrouselText(
                listOfCardSectionText = listOfCardSectionTextTwo,
                selectedCarrouselText = selectedCarrousel,
                carrouselBackButtonClick = carrouselBackButtonClick,
                carrouselForwardButtonClick = carrouselForwardButtonClick
            )

            Spacer(
                modifier = Modifier
                    .height(50.dp)
            )

            Image(
                painter = painterResource(R.drawable.breakthemoldpic),
                contentDescription = "Picture of a model in the NeverAnother Bra with the Break the mold written over it",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Spacer(
                modifier = Modifier
                    .height(50.dp)
            )

            DeliveryTimeTexts()


            Spacer(
                modifier = Modifier
                    .height(40.dp)
            )

            BottomLogo()


            Spacer(
                modifier = Modifier
                    .height(120.dp)
            )
        }
    }
}