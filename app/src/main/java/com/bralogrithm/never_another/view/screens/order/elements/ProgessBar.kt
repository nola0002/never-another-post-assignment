package com.bralogrithm.never_another.view.screens.order.elements

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProgessBar(
    pageCount: Int,
    currentPage: Int,
    onBackClick: () -> Unit,
    onClose: () -> Unit
) {

    Column() {

        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(horizontal = 8.dp)
            .padding(top = 45.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            repeat(pageCount) { index ->

                val targetPage = when {
                    index < currentPage -> Color.DarkGray
                    index == currentPage -> Color.DarkGray
                    else -> Color.LightGray
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(2.dp)
                        .clip(RoundedCornerShape(1.dp))
                        .background(targetPage)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(targetPage)
                    )
                }
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onBackClick,
                modifier = Modifier
                    .size(60.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF2F2F2),
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Gå tilbage",
                    Modifier
                        .size(40.dp),
                    tint = Color.Black
                )
            }

            Button(
                onClick = onClose,
                modifier = Modifier
                    .size(60.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF2F2F2),
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "LUk",
                    Modifier
                        .size(40.dp),
                    tint = Color.Black
                )
            }
        }

    }


}