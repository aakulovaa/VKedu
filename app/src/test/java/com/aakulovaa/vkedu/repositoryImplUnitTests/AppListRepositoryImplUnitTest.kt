package com.aakulovaa.vkedu.repositoryImplUnitTests

import com.aakulovaa.vkedu.data.api.AppListApi
import com.aakulovaa.vkedu.data.dto.AppListItemDto
import com.aakulovaa.vkedu.data.mappers.AppListMapper
import com.aakulovaa.vkedu.data.repositoryImpl.AppListRepositoryImpl
import com.aakulovaa.vkedu.domain.model.AppListItem
import com.aakulovaa.vkedu.domain.model.Category
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.mockito.Mockito
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.Test
import kotlin.test.assertEquals

class AppListRepositoryImplUnitTest {
    private val mapper = Mockito.mock<AppListMapper>()
    private val api = Mockito.mock<AppListApi>()

    private lateinit var repository: AppListRepositoryImpl

    private val dto = AppListItemDto(
        id = "1",
        title = "СберБанк Онлайн — с Салютом",
        description = "Больше чем банк",
        category = "Финансы",
        iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png"
    )

    private val domain = AppListItem(
        id = "1",
        title = "СберБанк Онлайн — с Салютом",
        description = "Больше чем банк",
        category = Category.FINANCE,
        iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png"
    )

    @Before
    fun setup() {
        repository = AppListRepositoryImpl(mapper, api)
    }

    @Test
    fun `return mapped list from api`() = runTest {
        whenever(api.getAppList()).thenReturn(listOf(dto))
        whenever(mapper.appListToDomain(dto)).thenReturn(domain)

        val result = repository.getAppList()

        assertEquals(listOf(domain), result)
    }

    @Test
    fun `call api when getting list`() = runTest {
        whenever(api.getAppList()).thenReturn(emptyList())

        repository.getAppList()

        verify(api).getAppList()
    }

    @Test
    fun `return empty list if api is empty`() = runTest {
        whenever(api.getAppList()).thenReturn(emptyList())

        val result = repository.getAppList()

        TestCase.assertTrue(result.isEmpty())
    }

}