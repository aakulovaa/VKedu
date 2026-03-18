package com.aakulovaa.vkedu.domain

data class AppDetails(
    val id: String,
    val title: String,
    val developer: String,
    val description: String,
    val category: Category,
    val iconUrl: String,
    val ageRating: Int,
    val size: Float,
    val screenshotUrlList: List<String>
)