package com.bralogrithm.never_another.view.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.model.exploreCarrouselOne
import com.bralogrithm.never_another.ui.theme.*
import com.bralogrithm.never_another.view.components.NavigationBarBottom
import com.bralogrithm.never_another.view.screens.explore.elements.CardCarrouselText
import com.bralogrithm.never_another.view.screens.home.elements.*
import com.bralogrithm.never_another.viewmodel.NeverAnotherViewModel

@Composable
fun HomeScreen(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<NeverAnotherViewModel>()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBarBottom(
                selectedScreen = selectedScreen,
                onScreenClick = onScreenClick
            )
        }
    ) { innerPadding ->
        LazyColumn(
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
            item {
                Banner()
                ImageArea()
            }
            item {
                Spacer(Modifier.height(40.dp))
                CardCarrouselText(
                    listOfCardSectionText = exploreCarrouselOne,
                    selectedCarrouselText = viewModel.exploreCarrouselIndex,
                    carrouselBackButtonClick = { viewModel.carrouselBackButtonClick() },
                    carrouselForwardButtonClick = { viewModel.carrouselForwardButtonClick() }
                )
            }
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    text = "til alle størrelser".uppercase(),
                    style = TextStyle(
                        fontSize = 36.sp,
                        lineHeight = 54.sp,
                        fontFamily = NohemiFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                )
            }
            item { DescriptiveGrid() }
            item { TwoByTwoGrid() }
            item { BottomLogo() }
        }
    }
}