package com.aakulovaa.vkedu.data.mappers

import com.aakulovaa.vkedu.data.dto.AppDetailsDto
import com.aakulovaa.vkedu.domain.model.AppDetails

class AppDetailsMapper(
    private val categoryMapper: CategoryMapper
) {
    fun appDetailsToDomain(dto: AppDetailsDto): AppDetails = AppDetails(
        id = dto.id,
        title = dto.title,
        developer = dto.developer,
        description = dto.description,
        category = categoryMapper.toDomain(dto.category),
        iconUrl = dto.iconUrl,
        ageRating = dto.ageRating,
        size = dto.size,
        screenshotUrlList = dto.screenshotUrlList
    )
}