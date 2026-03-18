package com.aakulovaa.vkedu.data.mappers

import com.aakulovaa.vkedu.domain.model.Category

class CategoryMapper {
    fun toDomain(category: String): Category = when(category){
                "Инструменты" -> Category.TOOLS
                "Транспорт и навигация" -> Category.TRANSPORT
                "Финансы" -> Category.FINANCE
                else -> throw IllegalStateException("Unsupported category type $category")
    }
}