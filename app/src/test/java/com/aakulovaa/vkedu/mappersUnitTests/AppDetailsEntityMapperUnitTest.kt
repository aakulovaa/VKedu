package com.aakulovaa.vkedu.mappersUnitTests

import com.aakulovaa.vkedu.data.dto.AppDetailsDto
import com.aakulovaa.vkedu.data.local.AppDetailsEntity
import com.aakulovaa.vkedu.data.local.AppDetailsEntityMapper
import com.aakulovaa.vkedu.domain.model.AppDetails
import com.aakulovaa.vkedu.domain.model.Category
import junit.framework.TestCase.assertTrue
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AppDetailsEntityMapperUnitTest {
    private val mapper = AppDetailsEntityMapper()

    private val domain = AppDetails(
        id = "1",
        title = "СберБанк Онлайн — с Салютом",
        developer = "Сбербанк",
        description = "Больше чем банк",
        category = Category.FINANCE,
        iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png",
        ageRating = 3,
        size = 45.6f,
        screenshotUrlList = emptyList(),
        isInWishlist = false
    )

    private val entity = AppDetailsEntity(
        id = "1",
        name = "СберБанк Онлайн — с Салютом",
        developer = "Сбербанк",
        description = "Больше чем банк",
        category = Category.FINANCE,
        iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png",
        ageRating = 3,
        size = 45.6f,
        screenshots = null,
        isInWishlist = false
    )

    @Test
    fun `map appDetails from domain to entity`(){
        val result = mapper.toEntity(domain)

        assertEquals(domain.id, result.id)
        assertEquals(domain.title, result.name)
        assertEquals(domain.developer, result.developer)
        assertEquals(domain.description, result.description)
        assertEquals(domain.category, result.category)
        assertEquals(domain.iconUrl, result.iconUrl)
        assertEquals(domain.ageRating, result.ageRating)
        assertEquals(domain.size, result.size)
        assertEquals(domain.isInWishlist, result.isInWishlist)

        assertNull(result.screenshots)
    }

    @Test
    fun `map appDetails from entity to domain`(){
        val result = mapper.toDomain(entity)

        assertEquals(entity.id, result.id)
        assertEquals(entity.name, result.title)
        assertEquals(entity.developer, result.developer)
        assertEquals(entity.description, result.description)
        assertEquals(entity.category, result.category)
        assertEquals(entity.iconUrl, result.iconUrl)
        assertEquals(entity.ageRating, result.ageRating)
        assertEquals(entity.size, result.size)
        assertEquals(entity.isInWishlist, result.isInWishlist)

        assertTrue(result.screenshotUrlList.isEmpty())
    }
}