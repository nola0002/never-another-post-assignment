package com.bralogrithm.never_another.model

data class Label(
    val labelName: String,
    val subScreen: SubScreensProfile
)

enum class SubScreensProfile {
    MyProfile,
    MyInformation,
    AfterCare,
    OrderStatus,
    FAQ
}

val labels = listOf(
    Label(
        labelName = "MINE OPLYSNINGER",
        subScreen = SubScreensProfile.MyInformation
    ),
    Label(
        labelName = "EFTER PLEJE",
        subScreen = SubScreensProfile.AfterCare
    ),
    Label(
        labelName = "ORDER STATUS",
        subScreen = SubScreensProfile.OrderStatus
    ),
    Label(
        labelName = "FAQ",
        subScreen = SubScreensProfile.FAQ
    ),

)
