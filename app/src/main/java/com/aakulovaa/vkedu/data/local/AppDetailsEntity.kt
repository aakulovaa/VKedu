package com.aakulovaa.vkedu.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aakulovaa.vkedu.domain.model.Category

@Entity(tableName = "app_details")
data class AppDetailsEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val developer: String,
    val description: String,
    val category: Category,
    val iconUrl: String,
    val ageRating: Int,
    val size: Float,
    val screenshots: String? = null,
    val isInWishlist: Boolean = false,
    val lastUpdated: Long = System.currentTimeMillis()
)
