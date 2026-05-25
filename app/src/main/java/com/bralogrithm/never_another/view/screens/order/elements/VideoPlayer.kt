package com.bralogrithm.never_another.view.screens.order.elements

import android.net.Uri
import android.widget.VideoView
import androidx.annotation.RawRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.unit.dp

// Videoerne er 16:9, så de overflow'er ud i siderne når de fylder højden,
// så det giver det fyldte instagram-look.

// Skrevet med Claude Opus 4.7 for at importere videoer korrekt.

@Composable
fun VideoPlayer(
    @RawRes rawResId: Int
) {

    var playing by remember { mutableStateOf(true) }

    BoxWithConstraints(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .clipToBounds(),
        contentAlignment = Alignment.Center
    ) {

        val videoHeight = maxHeight
        val videoWidth = videoHeight * 16f / 9f

        AndroidView(
            factory = { ctx ->
                VideoView(ctx).apply {
                    setVideoURI(Uri.parse("android.resource://${ctx.packageName}/$rawResId"))
                    setOnPreparedListener { mp ->
                        mp.isLooping = true
                        mp.setVolume(0f, 0f)
                        start()
                    }
                }
            },
            update = { view ->
                if (playing && !view.isPlaying) view.start()
                if (!playing && view.isPlaying) view.pause()
            },
            modifier = Modifier
                .requiredHeight(videoHeight)
                .requiredWidth(videoWidth)
        )

        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {

            Button(
                onClick = { playing = !playing },
                modifier = Modifier
                    .padding(12.dp)
                    .size(48.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF2F2F2),
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = if (playing) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                    contentDescription = if (playing) "Pause" else "Afspil",
                    Modifier
                        .size(28.dp),
                    tint = Color.Black
                )
            }

        }

    }
}
