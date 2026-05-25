package com.bralogrithm.never_another.view.screens.profile.subscreens.orderstatus

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily
import com.bralogrithm.never_another.view.screens.profile.subscreens.components.BackArrow

@Composable
fun OrderStatusScreen(
    onBackClick: () -> Unit,
    onClickGoToAfterCare: () -> Unit
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

            Text(
                text = "Ordre Status",
                fontFamily = NohemiFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 40.sp,
                modifier = Modifier
                    .offset(40.dp)
                    .padding(top = 54.dp)
            )

            Box(
                modifier = Modifier

            ){

                Image(
                    painter = painterResource(R.drawable.orderstatuspic),
                    contentDescription = "NeverAnother Branding and a picture with 3D knitted in one piece",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp, start = 30.dp),
                    contentScale = ContentScale.FillWidth,
                )

                Box(
                    modifier = Modifier
                        .offset(y = 690.dp)
                        .height(80.dp)
                        .width(400.dp)
                        .clickable(onClick = onClickGoToAfterCare)
                ) {

                }
            }





        }
    }
}
