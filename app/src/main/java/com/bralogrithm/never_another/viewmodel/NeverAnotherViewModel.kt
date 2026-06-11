package com.bralogrithm.never_another.viewmodel

/*
 * Lavet af Noah
 *
 * Hoved-ViewModel der holder den globale UI-state for appen.
 * Den styrer hvilken skærm der vises, valgt underprofil-skærm,
 * karrusel-index på Explore-fanen og valgt farve på bh'en.
 * Holdes som en enkelt instans i MainActivity og deles med alle skærme.
 *
 */

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.bralogrithm.never_another.model.BraColor
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.model.SubScreensProfile
import com.bralogrithm.never_another.model.exploreCarrouselOne
import com.bralogrithm.never_another.model.picturesForBlackBraCarrousel
import com.bralogrithm.never_another.model.picturesForWhiteBraCarrousel

class NeverAnotherViewModel : ViewModel() {

    // Hvilken hovedfane der vises i bunden af appen (Home, Explore, MyBra, Profile).
    var selectedScreen by mutableStateOf(Screen.Home)

    fun onScreenSelected(navController: NavController, screen: Screen) {
        selectedScreen = screen   // staten
        val route = when (screen) {
            Screen.Home    -> "home-screen"
            Screen.Explore -> "explore-screen"
            Screen.MyBra   -> "mybra-screen"
            Screen.Profile -> "profile-screen"
        }
        navController.navigate(route) {
            launchSingleTop = true  // Genbruger skærmen hvis den allerede er øverst i backstacken
            restoreState = true // Gemme det state der var tilgængeligt da man forlod siden
        }
    }


    // Hvilken underside af profilen der vises (oplysninger, FAQ, ordrestatus osv.).
    var selectedSubScreenProfile by mutableStateOf(SubScreensProfile.MyInformation)

    fun onSubScreenProfileSelected(navController: NavController, subScreen: SubScreensProfile) {
        selectedSubScreenProfile = subScreen   // Staten

        val route = when (subScreen) {
            SubScreensProfile.MyInformation -> "myinformation-subscreen"
            SubScreensProfile.AfterCare     -> "aftercare-subscreen"
            SubScreensProfile.OrderStatus   -> "orderstatus-subscreen"
            SubScreensProfile.FAQ           -> "faq-subscreen"
        }
        navController.navigate(route)
    }

    // State til karruselerne på Explore-fanen og valgt farve på bh'en.
    var exploreCarrouselIndex by mutableStateOf(0)
    var selectedColor by mutableStateOf(BraColor.White)

    // Liste af billeder der vises i Explore-karruselen - skifter når farven skiftes.
    var selectedCarouselPictures by mutableStateOf(picturesForWhiteBraCarrousel)

    // Bruges fra Explore-fanen til at vælge farve via farveprikkerne.
    // Skifter både selectedColor og hvilken billedliste karruselen viser.
    fun selectColor(color: BraColor) {
        selectedColor = color
        selectedCarouselPictures = when (color) {
            BraColor.White -> picturesForWhiteBraCarrousel
            BraColor.Black -> picturesForBlackBraCarrousel
        }
    }

    // Lavet af Kai - bruges til homescreen bra color toggle.
    fun toggleHomeBraColor() {
        selectedColor = if (selectedColor == BraColor.White) BraColor.Black else BraColor.White
    }
  

    // Flag der signalerer om et ordreflow er i gang (bruges til at skjule navigation osv.).
    var onGoingFlow by mutableStateOf(false)

    // Bladrer et trin tilbage i Explore-karruselen. Wrapper rundt til sidste element
    // hvis vi er på første - så karruselen føles uendelig.
    fun carrouselBackButtonClick() {
        if (exploreCarrouselIndex == 0) {
            exploreCarrouselIndex = exploreCarrouselOne.size - 1
        } else {
            exploreCarrouselIndex -= 1
        }
    }

    // Bladrer et trin frem i Explore-karruselen. Wrapper rundt til første element
    // hvis vi er på sidste.
    fun carrouselForwardButtonClick() {
        if (exploreCarrouselIndex == exploreCarrouselOne.size - 1) {
            exploreCarrouselIndex = 0
        } else {
            exploreCarrouselIndex += 1
        }
    }



}