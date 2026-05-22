package com.bralogrithm.never_another.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bralogrithm.never_another.model.BraCarrouselPicture
import com.bralogrithm.never_another.model.BraColor
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.model.exploreCarrouselOne
import com.bralogrithm.never_another.model.picturesForBlackBraCarrousel
import com.bralogrithm.never_another.model.picturesForWhiteBraCarrousel

class NeverAnotherViewModel : ViewModel() {

    var selectedScreen by mutableStateOf(Screen.Home)


    var exploreCarrouselIndex by mutableStateOf(0)
    var selectedColor by mutableStateOf(BraColor.WHITE)


    var selectedCarouselPictures by mutableStateOf(picturesForWhiteBraCarrousel)
    fun selectColor(color: BraColor) {
        selectedColor = color
        selectedCarouselPictures = when (color) {
            BraColor.WHITE -> picturesForWhiteBraCarrousel
            BraColor.BLACK -> picturesForBlackBraCarrousel
        }
    }

    var onGoingFlow by mutableStateOf(false)

    fun carrouselBackButtonClick() {
        if (exploreCarrouselIndex == 0) {
            exploreCarrouselIndex = exploreCarrouselOne.size - 1
        } else {
            exploreCarrouselIndex -= 1
        }
    }

    fun carrouselForwardButtonClick() {
        if (exploreCarrouselIndex == exploreCarrouselOne.size - 1) {
            exploreCarrouselIndex = 0
        } else {
            exploreCarrouselIndex += 1
        }
    }
}