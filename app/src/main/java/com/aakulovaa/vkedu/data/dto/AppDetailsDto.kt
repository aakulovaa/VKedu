package com.aakulovaa.vkedu.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppDetailsDto(
    val id: String,
    @SerialName("name")
    val title: String,
    val developer: String,
    val description: String,
    val category: String,
    val iconUrl: String,
    val ageRating: Int,
    val size: Float,
    val screenshotUrlList: List<String>
)