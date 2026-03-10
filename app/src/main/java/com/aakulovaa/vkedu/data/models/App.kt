package com.aakulovaa.vkedu.data.models

data class App(
    val title: String,
    val description: String,
    val category: Category,
    val iconUrl: String,
    val ageRating: Int,
    val size: Float,
    val screenshotUrlList: List<String>
)