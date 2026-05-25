package com.bralogrithm.never_another.view.screens.profile.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bralogrithm.never_another.R
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily

@Composable
fun ProfileHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profil picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
        )

        Box(
            modifier = Modifier
                .height(35.dp)
        ) {
            Text(
                text = "MIN PROFIL",
                fontSize = 45.sp,
                fontWeight = Medium,
                fontFamily = NohemiFontFamily
            )

            Image(
                painter = painterResource(R.drawable.brushstrokes),
                contentDescription = "Brush Stroke",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .offset(x = 180.dp, y = (-30).dp)
                    .rotate(20f)
            )
        }
    }
}