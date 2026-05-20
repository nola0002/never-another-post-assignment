package com.bralogrithm.never_another.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bralogrithm.never_another.model.ExploreCardSectionText
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.model.TrustPilotCardInfo
import com.bralogrithm.never_another.view.screens.explore.TrustPilotCard

class NeverAnotherViewModel : ViewModel() {

    var selectedScreen by mutableStateOf(Screen.Home)


    var exploreCarrouselOneIndex by mutableStateOf(0)


    var onGoingFlow by mutableStateOf(false)

    var exploreCarrouselOne by mutableStateOf(
        listOf(
            ExploreCardSectionText(
                thickText = "Blød bøjle, der løfter uden at trykke",
                thinText = "En indstrikket bøjle erstatter den hårde metalbøjle. Den løfter, former og glemmer dig aldrig – men du glemmer den."
            ),
            ExploreCardSectionText(
                thickText = "Dobbeltlagede skåle",
                thinText = "Et ydre lag, der holder formen. Et indre lag i blød cupro, der ånder med dig."
            ),
            ExploreCardSectionText(
                thickText = "Bredt underbånd, der bare sidder",
                thinText = "Det er underbåndet, der bærer bh'en – og dig. Vores er bredt, blødt og tæt. Tryg fra morgen til aften."
            ),
            ExploreCardSectionText(
                thickText = "Luftig ryg og sider",
                thinText = "Strikken er let og luftig dér, hvor du har brug for det. Du holdes kølig – også på de lange dage."
            ),
        )
    )

    fun carrouselBackButtonClick() {
        if (exploreCarrouselOneIndex == 0) {
            exploreCarrouselOneIndex = exploreCarrouselOne.size - 1
        } else {
            exploreCarrouselOneIndex -= 1
        }
    }

    fun carrouselForwardButtonClick() {
        if (exploreCarrouselOneIndex == exploreCarrouselOne.size - 1) {
            exploreCarrouselOneIndex = 0
        } else {
            exploreCarrouselOneIndex += 1
        }
    }

    var trustPilotCards by mutableStateOf(
        listOf(
            TrustPilotCardInfo(
                name = "Karen Sørensen",
                date = "1. april 2026",
                stars = 5,
                review = "TUSIND TAK FOR ET ENESTÅENDE DYGTIGT DESIGN ... JEG ER SÅ TILFREDS & GLAD !"
            ),
            TrustPilotCardInfo(
                name = "Susanne Jensen",
                date = "24. februar 2026",
                stars = 5,
                review = "Fremragende bh, Man mærker ikke at man har BH på. "
            ),
            TrustPilotCardInfo(
                name = "Susanne Jensen",
                date = "24. februar 2026",
                stars = 5,
                review = "Der er en rigtig god vejledning i forbindelse med bestilling. Og slutproduktet lever 100% op til forventningerne. En super behagelig BH."
            )
        )
    )

    var exploreCarrouselTwo by mutableStateOf(
        listOf(
            ExploreCardSectionText(
                thickText = "Ingen sømme",
                thinText = "Intet, der gnaver. Intet, der trykker. Bh'en glider hen over huden i én blød bevægelse."
            ),
            ExploreCardSectionText(
                thickText = "Tredimensionel pasform",
                thinText = "Strikken bygges op i forskellige tykkelser og strukturer på samme tid. Fast dér, hvor den skal støtte. Blød dér, hvor den skal følge dig."
            ),
            ExploreCardSectionText(
                thickText = "Stof, der bevæger sig med dig",
                thinText = "Strikken har et naturligt stræk. Den strammer ikke. Den slipper ikke. Den følger bare med – når du trækker vejret, løfter armene, læner dig tilbage."
            ),
            ExploreCardSectionText(
                thickText = "Ingen rester. Intet spild",
                thinText = "Når en bh strikkes i ét stykke, er der intet stof tilbage på gulvet. Kun det, du har på."
            ),

            )
    )


}