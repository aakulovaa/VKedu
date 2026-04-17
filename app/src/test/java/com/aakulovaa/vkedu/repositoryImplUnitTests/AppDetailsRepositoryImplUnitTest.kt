package com.aakulovaa.vkedu.repositoryImplUnitTests

import com.aakulovaa.vkedu.data.api.AppDetailsApi
import com.aakulovaa.vkedu.data.dto.AppDetailsDto
import com.aakulovaa.vkedu.data.local.AppDetailsDao
import com.aakulovaa.vkedu.data.local.AppDetailsEntity
import com.aakulovaa.vkedu.data.local.AppDetailsEntityMapper
import com.aakulovaa.vkedu.data.mappers.AppDetailsMapper
import com.aakulovaa.vkedu.data.repositoryImpl.AppDetailsRepositoryImpl
import com.aakulovaa.vkedu.domain.model.AppDetails
import com.aakulovaa.vkedu.domain.model.Category
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class AppDetailsRepositoryImplUnitTest {

    private val mapper = Mockito.mock<AppDetailsMapper>()
    private val api = Mockito.mock<AppDetailsApi>()
    private val dao = Mockito.mock<AppDetailsDao>()
    private val entityMapper = Mockito.mock<AppDetailsEntityMapper>()

    private lateinit var repository: AppDetailsRepositoryImpl

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

    private val dto = AppDetailsDto(
        id = "1",
        title = "СберБанк Онлайн — с Салютом",
        developer = "Сбербанк",
        description = "Больше чем банк",
        category = "Финансы",
        iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png",
        ageRating = 3,
        size = 45.6f,
        screenshotUrlList = emptyList()
    )

    @Before
    fun setup(){
        repository = AppDetailsRepositoryImpl(
            mapper = mapper,
            api = api,
            dao = dao,
            entityMapper = entityMapper
        )
    }

    @Test
     fun `get appDetails from db`()= runTest {
        whenever(dao.getAppDetails("1")).thenReturn(flowOf(entity))
        whenever(entityMapper.toDomain(entity)).thenReturn(domain)

        val result = repository.getAppDetails("1")

        assertEquals(domain, result)
        verify(api, Mockito.never()).getAppDetails(any())
    }

    @Test
    fun `get appDetails from api if db is empty`() = runTest {
        whenever(dao.getAppDetails("1")).thenReturn(flowOf(null))
        whenever(api.getAppDetails("1")).thenReturn(dto)
        whenever(mapper.appDetailsToDomain(dto)).thenReturn(domain)
        whenever(entityMapper.toEntity(domain)).thenReturn(entity)

        val result = repository.getAppDetails("1")

        assertEquals(domain, result)
        verify(api).getAppDetails("1")
    }

    @Test
    fun `save appDetails in the db if it was empty`() = runTest {
        whenever(dao.getAppDetails("1")).thenReturn(flowOf(null))
        whenever(api.getAppDetails("1")).thenReturn(dto)
        whenever(mapper.appDetailsToDomain(dto)).thenReturn(domain)
        whenever(entityMapper.toEntity(domain)).thenReturn(entity)

        repository.getAppDetails("1")

        verify(dao).insertAppDetails(entity)
    }

    @Test
    fun `update wishlist when toggle called`() = runTest {
        whenever(dao.getAppDetails("1")).thenReturn(flowOf(entity.copy(isInWishlist = false)))

        repository.toggleWishlist("1")

        verify(dao).updateWishlistStatus("1", true)
    }
}