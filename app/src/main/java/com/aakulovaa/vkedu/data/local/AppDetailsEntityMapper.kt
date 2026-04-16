package com.aakulovaa.vkedu.data.local

import com.aakulovaa.vkedu.domain.model.AppDetails

class AppDetailsEntityMapper {
    fun toEntity(domain: AppDetails): AppDetailsEntity = AppDetailsEntity(
        id = domain.id,
        name = domain.title,
        developer = domain.developer,
        description = domain.description,
        category = domain.category,
        iconUrl = domain.iconUrl,
        ageRating = domain.ageRating,
        size = domain.size,
        screenshots = domain.screenshotUrlList.joinToString("|"),
        isInWishlist = domain.isInWishlist
    )

    fun toDomain(entity: AppDetailsEntity): AppDetails = AppDetails(
        id = entity.id,
        title = entity.name,
        developer = entity.developer,
        description = entity.description,
        category = entity.category,
        iconUrl = entity.iconUrl,
        ageRating = entity.ageRating,
        size = entity.size,
        screenshotUrlList = entity.screenshots ?.takeIf { it.isNotBlank() }?.split('|') ?: emptyList(),
        isInWishlist = entity.isInWishlist
    )
}