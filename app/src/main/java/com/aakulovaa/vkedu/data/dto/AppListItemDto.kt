package com.aakulovaa.vkedu.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppListItemDto(
    val id: String,
    @SerialName("name")
    val title: String,
    val description: String,
    val category: String,
    val iconUrl: String
)