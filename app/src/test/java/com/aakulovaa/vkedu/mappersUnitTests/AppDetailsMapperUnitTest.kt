package com.aakulovaa.vkedu.mappersUnitTests

import com.aakulovaa.vkedu.data.dto.AppDetailsDto
import com.aakulovaa.vkedu.data.mappers.AppDetailsMapper
import com.aakulovaa.vkedu.data.mappers.CategoryMapper
import com.aakulovaa.vkedu.domain.model.Category
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class AppDetailsMapperUnitTest {
    private val categoryMapper: CategoryMapper = mock()
    private val mapper = AppDetailsMapper(categoryMapper)

    private val dto = AppDetailsDto(
        id = "1",
        title = "СберБанк Онлайн — с Салютом",
        developer = "Сбербанк",
        description = "Больше чем банк",
        category = "Финансы",
        iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png",
        ageRating = 3,
        size = 45.6f,
        screenshotUrlList = listOf("https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png")
    )

    @Test
    fun `map appDetailsDto to domain`(){
        whenever(categoryMapper.toDomain("Финансы"))
            .thenReturn(Category.FINANCE)

        val result = mapper.appDetailsToDomain(dto)

        assertEquals(dto.id, result.id)
        assertEquals(dto.title, result.title)
        assertEquals(dto.developer, result.developer)
        assertEquals(dto.description, result.description)
        assertEquals(Category.FINANCE, result.category)
        assertEquals(dto.iconUrl, result.iconUrl)
        assertEquals(dto.ageRating, result.ageRating)
        assertEquals(dto.size, dto.size)
        assertEquals(dto.screenshotUrlList, result.screenshotUrlList)
    }
}