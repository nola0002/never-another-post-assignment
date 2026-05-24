package com.bralogrithm.never_another.model

enum class TimeLineStatus {
    Done,
    Current,
    Upcoming
}

data class TimeLineItem(
    val title: String,
    val status: TimeLineStatus,
    val hasVideo: Boolean
)