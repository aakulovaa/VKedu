package com.aakulovaa.vkedu.mappersUnitTests

import com.aakulovaa.vkedu.data.dto.AppListItemDto
import com.aakulovaa.vkedu.data.mappers.AppListMapper
import com.aakulovaa.vkedu.data.mappers.CategoryMapper
import com.aakulovaa.vkedu.domain.model.Category
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import kotlin.test.Test
import kotlin.test.assertEquals

class AppListMapperUnitTest {
    private val categoryMapper: CategoryMapper = mock()
    private val mapper = AppListMapper(categoryMapper)

    private val dto = AppListItemDto(
        id = "1",
        title = "СберБанк Онлайн — с Салютом",
        description = "Больше чем банк",
        category = "Финансы",
        iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png"
    )

    @Test
    fun `map appListDto to domain`() {
        whenever(categoryMapper.toDomain("Финансы"))
            .thenReturn(Category.FINANCE)

        val result = mapper.appListToDomain(dto)

        assertEquals(dto.id, result.id)
        assertEquals(dto.title, result.title)
        assertEquals(dto.description, result.description)
        assertEquals(Category.FINANCE, result.category)
        assertEquals(dto.iconUrl, result.iconUrl)
    }
}