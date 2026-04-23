package com.aakulovaa.vkedu.domain.model

data class AppListItem(
    val id: String,
    val title: String,
    val description: String,
    val category: Category,
    val iconUrl: String
)