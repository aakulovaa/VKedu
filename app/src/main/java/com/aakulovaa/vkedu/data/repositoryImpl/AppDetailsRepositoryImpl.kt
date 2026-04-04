package com.aakulovaa.vkedu.data.repositoryImpl

import com.aakulovaa.vkedu.data.api.AppDetailsApi
import com.aakulovaa.vkedu.data.mappers.AppDetailsMapper
import com.aakulovaa.vkedu.domain.model.AppDetails
import com.aakulovaa.vkedu.domain.repository.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppDetailsRepositoryImpl(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsApi
) : AppDetailsRepository {
    override suspend fun getAppDetails(id: String): AppDetails =
    withContext(Dispatchers.IO) {
        val dto = api.getAppDetails(id)
        mapper.appDetailsToDomain(dto)
    }
}