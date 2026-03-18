package com.aakulovaa.vkedu.data.repositoryImpl

import com.aakulovaa.vkedu.data.api.AppDetailsApi
import com.aakulovaa.vkedu.data.mappers.AppDetailsMapper
import com.aakulovaa.vkedu.domain.model.AppDetails
import com.aakulovaa.vkedu.domain.repository.AppDetailsRepository

class AppDetailsRepositoryImpl(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsApi
) : AppDetailsRepository {
    override suspend fun getAppDetails(id: String): AppDetails {
        val dto = api.getAppDetails(id)
        return mapper.appDetailsToDomain(dto)
    }
}