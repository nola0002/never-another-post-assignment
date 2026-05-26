package com.bralogrithm.never_another.view.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.model.BraColor
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.ui.theme.*
import com.bralogrithm.never_another.view.components.BottomLogo
import com.bralogrithm.never_another.view.components.NavigationBarBottom
import com.bralogrithm.never_another.view.screens.home.elements.*

@Composable
fun HomeScreen(
    selectedScreen: Screen,
    onScreenClick: (Screen) -> Unit,
    modifier: Modifier = Modifier,
    selectedColor: BraColor,
    onToggleColor: () -> Unit,
    ) {

    Scaffold(
        modifier = modifier,
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
            Banner()
            ImageArea()

            Spacer(Modifier.height(40.dp))


            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp),
                text = "Bra no. 1",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontFamily = NohemiFontFamily,
                    fontWeight = FontWeight(500),
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                )
            )

            HomeSelectBra(
                selectedColor = selectedColor,
                onToggleColor = onToggleColor
            )

            Spacer(Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            ) {
                TextButton(
                    onClick = { onScreenClick(Screen.MyBra) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        Orange
                    ),
                    shape = RoundedCornerShape(50)

                ) {
                    Text(
                        color = White,
                        fontSize = 25.sp,
                        text =  "Bestil BH".uppercase()
                    )
                }
            }


            Spacer(Modifier.height(40.dp))

            DescriptiveGrid()

            Spacer(Modifier.height(40.dp))

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

            TwoByTwoGrid()

            Spacer(Modifier.height(40.dp))

            BottomLogo()

            Spacer(Modifier.height(80.dp))
        }
    }
}
