package com.bralogrithm.never_another.view.screens.order.elements

/*
 * Lavet af Sylvester
 *
 * Lille composable der afspiller en loopet .gif fra res/raw — bruges som
 * loading-/venteanimation mens næste step bliver gjort klar.
 *
 */

import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

/*
 * Samme idé som VideoPlayer: en android-widget pakket ind i AndroidView,
 * så vi kan afspille gif'en uden at hive et nyt bibliotek ind.
 *
 * Skrevet med Claude Opus 4.7 til at få gif'en til at loope.
 *
 * Prompt brugt:
 * "Jeg har en gif som jeg gerne vil vise mens appen loader. Den ligger
 *  i res/raw. Hvordan får jeg den vist i Compose så den bliver ved med
 *  at loope? Jeg vil helst ikke hente et nyt bibliotek ind hvis det kan
 *  undgås."
 */

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
