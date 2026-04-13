package com.aakulovaa.vkedu.data.local

import androidx.room.TypeConverter
import com.aakulovaa.vkedu.domain.model.Category

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.valueOf(categoryName)
}