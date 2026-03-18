package com.aakulovaa.vkedu.data.mappers

import com.aakulovaa.vkedu.data.dto.AppListItemDto
import com.aakulovaa.vkedu.domain.model.AppListItem

class AppListMapper(private val categoryMapper: CategoryMapper) {
    fun appListToDomain(dto: AppListItemDto): AppListItem = AppListItem(
        id = dto.id,
        title = dto.title,
        description = dto.description,
        category = categoryMapper.toDomain(dto.category),
        iconUrl = dto.iconUrl
    )
}