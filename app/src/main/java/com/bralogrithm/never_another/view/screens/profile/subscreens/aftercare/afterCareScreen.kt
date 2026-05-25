package com.bralogrithm.never_another.view.screens.profile.subscreens.aftercare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily
import com.bralogrithm.never_another.view.components.TextWithBrushStroke
import com.bralogrithm.never_another.view.screens.profile.subscreens.aftercare.elements.AfterCareStepBoxes
import com.bralogrithm.never_another.view.screens.profile.subscreens.components.BackArrow

@Composable
fun AfterCareScreen(
    onBackClick: () -> Unit
) {

    Scaffold(
        bottomBar = {

        },
        topBar = {
            BackArrow(
                onBackClick = onBackClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = innerPadding.calculateStartPadding(LayoutDirection.Ltr), //
                    top = 0.dp,
                    end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
                    bottom = innerPadding.calculateBottomPadding()
                )
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(445.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(
                        modifier = Modifier.height(40.dp)
                    )

                    Text(
                        text = "Pleje af BH",
                        fontFamily = NohemiFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 40.sp
                    )

                    Image(
                        painter = painterResource(R.drawable.carrouselblackbrafour),
                        contentDescription = "Text that says Made for you. Only for you.",
                        modifier = Modifier
                            .size(300.dp)
                    )


                    TextWithBrushStroke(
                        text = "DIN BH",
                        fontSize = 30,
                        fontWeight = FontWeight.Medium,
                        boxHeight = 80,
                        boxPaddingStart = 159,
                        modifier = Modifier
                            .size(52.dp)
                            .offset(x = (-30).dp, y = (4).dp)
                            .rotate(221f)
                    )


                }

            }

            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .height(320.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center


            ) {
                Column(
                    modifier = Modifier
                        .padding(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Vaskeanvisning",
                        fontFamily = NohemiFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 36.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )

                    Spacer(
                        modifier = Modifier
                            .height(16.dp)
                    )

                    Text(
                        text = "Brug din bh i højst tre dage i træk, før den skal vaskes. Regelmæssig vask forlænger bh'ens levetid.",
                        fontFamily = NohemiFontFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }

            AfterCareStepBoxes(
                boxColor = Color.White,
                stepNumber = "1",
                stepText = "Finvask ved 30 grader",
                numberOnLeft = true
            )


            AfterCareStepBoxes(
                boxColor = Color.Black,
                stepNumber = "2",
                stepText = "Brug gerne en vaskepose",
                numberOnLeft = false
            )

            AfterCareStepBoxes(
                boxColor = Color.White,
                stepNumber = "3",
                stepText = "Vaskes med samme farve tøj",
                numberOnLeft = true
            )
            AfterCareStepBoxes(
                boxColor = Color.Black,
                stepNumber = "4",
                stepText = "Tåler ikke tørretumbling",
                numberOnLeft = false
            )

            AfterCareStepBoxes(
                boxColor = Color.White,
                stepNumber = "5",
                stepText = "Brug ikke skyllemiddel",
                numberOnLeft = true
            )
            AfterCareStepBoxes(
                boxColor = Color.Black,
                stepNumber = "6",
                stepText = "Tåler ikke blegemiddel",
                numberOnLeft = false
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color.Transparent)
            )

        }
    }
}