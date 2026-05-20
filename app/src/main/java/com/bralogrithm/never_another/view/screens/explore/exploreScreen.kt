package com.bralogrithm.never_another.view.screens.explore

import android.R.attr.contentDescription
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
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
import com.bralogrithm.never_another.model.ExploreCardSectionText
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.model.TrustPilotCardInfo
import com.bralogrithm.never_another.view.components.NavigationBarBottom

@Composable
fun ExploreScreen(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit,
    listOfCardSectionText: List<ExploreCardSectionText>,
    selectedCarrouselText: Int,
    carrouselBackButtonClick: () -> Unit,
    carrouselForwardButtonClick: () -> Unit,
    trustPilotCards: List<TrustPilotCardInfo>
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("This is the Explore Screen")



            TrustPilotCard(
                "Karen Sørensen",
                "1. april 2026",
                "TUSIND TAK FOR ET ENESTÅENDE DYGTIGT DESIGN ... JEG ER SÅ TILFREDS & GLAD !"
            )
            Text("Antal cards: ${trustPilotCards.size}")

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                items(trustPilotCards) {card ->
                    TrustPilotCard(
                        name = card.name,
                        date = card.date,
                        review = card.review
                    )
                }
            }


            Image(
                painter = painterResource(R.drawable.headerexplore),
                contentDescription = "NeverAnother Branding and a picture with 3D knitted in one piece",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Image(
                painter = painterResource(R.drawable.knittedinonepieceexplore),
                contentDescription = "NeverAnother Branding and a picture with 3D knitted in one piece",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            CardSection(
                listOfCardSectionText = listOfCardSectionText,
                selectedCarrouselText = selectedCarrouselText,
                carrouselBackButtonClick = carrouselBackButtonClick,
                carrouselForwardButtonClick = carrouselForwardButtonClick

            )
        }
    }
}