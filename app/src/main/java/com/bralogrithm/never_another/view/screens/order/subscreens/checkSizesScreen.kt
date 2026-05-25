package com.bralogrithm.never_another.view.screens.order.subscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.model.BraColor

fun convertColorToBraImage(color: BraColor): Int {
    return when (color) {
        BraColor.Black -> R.drawable.bra_black
        BraColor.White -> R.drawable.bra_white
    }
}

@Composable
fun CheckSizesScreen(
    selectedBraColor: BraColor,
    onToggleColor: () -> Unit,
    measurements: List<Pair<String, String>>,
    price: String
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
        ) {

            Image(
                painter = painterResource(convertColorToBraImage(selectedBraColor)),
                contentDescription = "BH i farven ${selectedBraColor}",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 60.dp)
            )

            Button(
                onClick = onToggleColor,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp)
                    .size(48.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Skift farve",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(28.dp)
                )
            }

            Button(
                onClick = onToggleColor,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 10.dp)
                    .size(48.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Skift farve",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(28.dp)
                )
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Black)
                    .border(
                        width = if (selectedBraColor == BraColor.Black) 3.dp else 0.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { if (selectedBraColor != BraColor.Black) onToggleColor() }
            )

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF0E6DE))
                    .border(
                        width = if (selectedBraColor == BraColor.White) 3.dp else 0.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { if (selectedBraColor != BraColor.White) onToggleColor() }
            )

        }

        Text(
            text = "SKRÆDDERSYET BH",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp)
        )

        measurements.forEach { (label, value) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 4.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = label,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = ".".repeat(80),
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    maxLines = 1,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 6.dp)
                )
                Text(
                    text = value,
                    fontSize = 16.sp,
                    color = Color(0xFF4A4A4A)
                )
            }
        }

        Spacer(
            modifier = Modifier
                .height(12.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(1.dp)
                .background(Color.LightGray)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Text(
                text = "Din pris",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                text = price,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

    }
}
