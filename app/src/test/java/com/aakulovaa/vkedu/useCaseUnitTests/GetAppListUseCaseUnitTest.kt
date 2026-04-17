package com.aakulovaa.vkedu.useCaseUnitTests

import com.aakulovaa.vkedu.domain.model.AppListItem
import com.aakulovaa.vkedu.domain.model.Category
import com.aakulovaa.vkedu.domain.repository.AppListRepository
import com.aakulovaa.vkedu.domain.useCase.GetAppListUseCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.Test

class GetAppListUseCaseUnitTest {
    private val repository: AppListRepository = mock()

    private val useCase = GetAppListUseCase(repository)

    private val domain = AppListItem(
        id = "1",
        title = "СберБанк Онлайн — с Салютом",
        description = "Больше чем банк",
        category = Category.FINANCE,
        iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png"
    )

    @Test
    fun `return appList`() = runTest {
        whenever(repository.getAppList())
            .thenReturn(listOf(domain))

        val result = useCase()

        assertEquals(1, result.size)
        assertEquals(domain, result.first())
    }

    @Test
    fun `return empty list when repository empty`() = runTest {
        whenever(repository.getAppList())
            .thenReturn(emptyList())

        val result = useCase()

        assertTrue(result.isEmpty())
    }

    @Test
    fun `request list from repository`() = runTest {
        whenever(repository.getAppList())
            .thenReturn(emptyList())

        useCase()

        verify(repository).getAppList()
    }
}