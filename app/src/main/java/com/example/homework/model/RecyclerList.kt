package com.example.homework.model

data class RecyclerList(val list: List<RecyclerData>?)
data class RecyclerData(
    val restaurantIdx: Double,
    val thumbnail: String,
    val classification: String,
    val restaurantName: String,
    val rating: Double,
    val reviewCount: Int,
    val summaryAddress: String,
    val isQuickBooking: Boolean,
    val isRemoteWaiting: Boolean,
    val useWaiting: Boolean,
    val useBooking: Boolean,
    val isNew: Boolean,
    val waitingCount: Int
)