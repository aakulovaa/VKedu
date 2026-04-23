package com.aakulovaa.vkedu.useCaseUnitTests

import com.aakulovaa.vkedu.domain.model.AppDetails
import com.aakulovaa.vkedu.domain.model.Category
import com.aakulovaa.vkedu.domain.repository.AppDetailsRepository
import com.aakulovaa.vkedu.domain.useCase.GetAppDetailsUseCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class GetAppDetailsUseCaseUnitTest {
    private val repository: AppDetailsRepository = mock()

    private val useCase = GetAppDetailsUseCase(repository)

    private val application = AppDetails(
        id = "1",
        title = "СберБанк Онлайн — с Салютом",
        developer = "Сбербанк",
        description = "Больше чем банк",
        category = Category.FINANCE,
        iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png",
        ageRating = 3,
        size = 45.6f,
        screenshotUrlList = listOf("https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png"),
        isInWishlist = false
    )

    @Test
    fun `return appDetails`() = runTest {
        whenever(repository.getAppDetails("1"))
            .thenReturn(application)

        val result = useCase("1")

        assertEquals("1", result.id)
        assertEquals("СберБанк Онлайн — с Салютом", result.title)
        assertEquals("Сбербанк", result.developer)
        assertEquals("Больше чем банк", result.description)
        assertEquals(Category.FINANCE, result.category)
        assertEquals("https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png", result.iconUrl)
        assertEquals(3, result.ageRating)
        assertEquals(45.6f, result.size)
        assertEquals(1, result.screenshotUrlList.size)
        assertFalse( result.isInWishlist)
    }

    @Test
    fun `returns data of the desired application`()= runTest {
        val secondApp = application.copy(
            id = "7",
            title = "Яндекс"
        )

        whenever(repository.getAppDetails("7"))
            .thenReturn(secondApp)

        val result = useCase("7")

        assertEquals("7", result.id)
        assertEquals("Яндекс", result.title)
    }

    @Test
    fun `observeAppDetails with correctId`() = runTest {
        whenever(repository.observeAppDetails("22"))
            .thenReturn(flowOf(application))

        useCase.observeAppDetails("22")

        verify(repository).observeAppDetails("22")
    }

    @Test
    fun `toggleWishlist for correct id`() = runTest {
        useCase.toggleWishlist("10")

        verify(repository).toggleWishlist("10")

    }
}