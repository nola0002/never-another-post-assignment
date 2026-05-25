package com.bralogrithm.never_another.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationBarElement(
    iconResId: Int,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
){
    if (!isSelected)
    Column(
        modifier = Modifier
            .height(60.dp)
            .width(70.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = text,
            modifier = Modifier.size(24.dp),
            tint = if (isSelected) Color.Black else Color.Gray
        )
        Text(
            text = text,
            fontSize = 10.sp,
            color = if (isSelected) Color.Black else Color.Gray
        )
    }

    if (isSelected)
        Column(
            modifier = Modifier
                .height(60.dp)
                .width(70.dp)
                .clickable(onClick = onClick)
                .padding(8.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(18.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = text,
                modifier = Modifier.size(24.dp),
                tint = if (isSelected) Color.Black else Color.Gray
            )
            Text(
                text = text,
                fontSize = 10.sp,
                color = if (isSelected) Color.Black else Color.Gray
            )
        }


}
