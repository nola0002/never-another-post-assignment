package com.bralogrithm.never_another.view.screens.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
import com.bralogrithm.never_another.view.screens.explore.elements.TrustPilotCard

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
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("This is the Explore Screen")




            Image(
                painter = painterResource(R.drawable.headerexplore),
                contentDescription = "Text that says Made for you. Only for you.",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text("Selected: $selectedColor")


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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(
                            text = "Farve: Hvid",
                            fontFamily = NohemiFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
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
                            selected = selectedColor == BraColor.WHITE,
                            onClick = onClickWhite
                        )
                        ColorDotCarrousel(
                            color = Color(0xff2A2A2C),
                            selected = selectedColor == BraColor.BLACK,
                            onClick = onClickBlack
                        )

                    }
                }
            }

            Image(
                painter = painterResource(R.drawable.knittedinonepieceexplore),
                contentDescription = "NeverAnother Branding and a picture with 3D knitted in one piece",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            CardCarrouselText(
                listOfCardSectionText = listOfCardSectionTextOne,
                selectedCarrouselText = selectedCarrousel,
                carrouselBackButtonClick = carrouselBackButtonClick,
                carrouselForwardButtonClick = carrouselForwardButtonClick

            )

            trustPilotCards.forEach { trustPilotCard ->
                TrustPilotCard(
                    name = trustPilotCard.name,
                    date = trustPilotCard.date,
                    review = trustPilotCard.review
                )
            }

            Image(
                painter = painterResource(R.drawable.womansowingmachine),
                contentDescription = "Woman at the sowing machine, that is used to make the NeverAnother bra",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            CardCarrouselText(
                listOfCardSectionText = listOfCardSectionTextTwo,
                selectedCarrouselText = selectedCarrousel,
                carrouselBackButtonClick = carrouselBackButtonClick,
                carrouselForwardButtonClick = carrouselForwardButtonClick
            )

            Image(
                painter = painterResource(R.drawable.breakthemoldpic),
                contentDescription = "Picture of a model in the NeverAnother Bra with the Break the mold written over it",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            DeliveryTimeTexts()

        }
    }
}