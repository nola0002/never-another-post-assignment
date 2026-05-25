package com.bralogrithm.never_another.view.screens.order.elements

import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

// Samme idé som VideoPlayer: en android-widget pakket ind i AndroidView,
// så vi kan afspille gif'en uden at hive et nyt bibliotek ind.

// Skrevet med Claude Opus 4.7 til at få gif'en til at loope.

@Composable
fun LoadingStateGif(
    @RawRes rawResId: Int,
    modifier: Modifier = Modifier
) {

    AndroidView(
        factory = { ctx ->
            ImageView(ctx).apply {
                scaleType = ImageView.ScaleType.FIT_CENTER
                val uri = Uri.parse("android.resource://${ctx.packageName}/$rawResId")
                val source = ImageDecoder.createSource(ctx.contentResolver, uri)
                val drawable = ImageDecoder.decodeDrawable(source)
                setImageDrawable(drawable)
                if (drawable is AnimatedImageDrawable) {
                    drawable.repeatCount = AnimatedImageDrawable.REPEAT_INFINITE
                    drawable.start()
                }
            }
        },
        modifier = modifier
    )

}
