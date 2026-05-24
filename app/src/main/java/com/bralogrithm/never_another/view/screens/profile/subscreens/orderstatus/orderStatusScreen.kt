package com.bralogrithm.never_another.view.screens.profile.subscreens.orderstatus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun OrderStatusScreen() {
    Scaffold(
        bottomBar = {

        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Ordre Status",
                fontFamily = NohemiFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 40.sp,

            )
        }


    }
}