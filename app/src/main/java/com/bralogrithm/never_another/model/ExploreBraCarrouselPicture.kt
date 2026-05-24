package com.bralogrithm.never_another.model

import com.bralogrithm.never_another.R

data class BraCarrouselPicture(
    val pictureId: Int
)

enum class BraColor { White, Black }


val picturesForWhiteBraCarrousel = listOf(
    BraCarrouselPicture(
        pictureId = R.drawable.carrouselwhitebraone
    ),
    BraCarrouselPicture(
        pictureId = R.drawable.carrouselwhitebratwo
    ),
    BraCarrouselPicture(
        pictureId = R.drawable.carrouselwhitebrathree
    ),
    BraCarrouselPicture(
        pictureId = R.drawable.carrouselwhitebrafour
    ),
    BraCarrouselPicture(
        pictureId = R.drawable.carrouselwhitebrafive
    )
)

val picturesForBlackBraCarrousel = listOf(
    BraCarrouselPicture(
        pictureId = R.drawable.carrouselblackbraone
    ),
    BraCarrouselPicture(
        pictureId = R.drawable.carrouselblackbratwo
    ),
    BraCarrouselPicture(
        pictureId = R.drawable.carrouselblackbrathree
    ),
    BraCarrouselPicture(
        pictureId = R.drawable.carrouselblackbrafour
    )
)

