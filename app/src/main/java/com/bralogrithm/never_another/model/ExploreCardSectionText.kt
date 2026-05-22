package com.bralogrithm.never_another.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class ExploreCardSectionText(
    val thickText: String,
    val thinText: String
)

val exploreCarrouselOne = listOf(
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

val exploreCarrouselTwo = listOf(
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
