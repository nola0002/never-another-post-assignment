package com.bralogrithm.never_another.model

enum class TimeLineStatus {
    Done,
    Current,
    Upcoming
}

data class TimeLineStep(
    val title: String,
    val status: TimeLineStatus,
    val hasVideo: Boolean = false
)

val steps = listOf(
    TimeLineStep("Bestilt BH", TimeLineStatus.Done),
    TimeLineStep("Din BH er ved at\nblive strikket", TimeLineStatus.Current, hasVideo = true),
    TimeLineStep("Din pakke sendes\ntil os", TimeLineStatus.Upcoming),
    TimeLineStep("Din pakke er på vej\ntil dig", TimeLineStatus.Upcoming),
    TimeLineStep("Din pakke er leveret\nhos dig", TimeLineStatus.Upcoming),
)