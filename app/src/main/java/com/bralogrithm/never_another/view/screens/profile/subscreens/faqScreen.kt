package com.bralogrithm.never_another.view.screens.profile.subscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bralogrithm.never_another.model.Question
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.model.questionlist
import com.bralogrithm.never_another.ui.theme.NohemiFontFamily
import com.bralogrithm.never_another.view.components.NavigationBarBottom
import com.bralogrithm.never_another.view.screens.profile.InfoStyle

@Composable
fun FaqScreen(
              onBackClick: () -> Unit
) {
    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Faqheader(onBackClick = onBackClick)

            Questions(questionlist)
        }
    }
}

@Composable
fun Faqheader(onBackClick: () -> Unit){
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp, start = 35.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Arrow(onBackClick = onBackClick)
        Text(
            text = "FAQ",
            fontSize = 45.sp,
            fontWeight = Medium,
            fontFamily = NohemiFontFamily
        )
    }
}


@Composable
fun Arrow(onBackClick: () -> Unit){
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
            contentDescription = "Back pointing arrow",
            Modifier
                .size(40.dp),
            tint = Color.Black

        )
    }
}

@Composable
fun Questions(
    question: List<Question>,
    modifier: Modifier = Modifier,) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        question.forEach { question ->  Questionstyle(title = question.title, answer = question.answer) }
    }

}

@Composable
fun Questionstyle(
    title: String,
    answer: String,
    modifier: Modifier = Modifier,
    ) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF2F2F2))
            .padding(7.dp)
            .width(325.dp),
    ) {
        Column() {
            Text(
                text = title,
                fontWeight = FontWeight.Medium,
                fontFamily = NohemiFontFamily
            )
            Smallline()
            Text(
                text = answer,
                fontWeight = FontWeight.ExtraLight,
                fontFamily = NohemiFontFamily
            )

        }
    }
}

@Composable
fun Smallline() {

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 272.dp, top = 6.dp, bottom = 6.dp),
            thickness = 0.5.dp,
            color = Color.Black
        )


}