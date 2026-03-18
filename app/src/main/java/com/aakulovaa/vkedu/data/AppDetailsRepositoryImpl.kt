package com.aakulovaa.vkedu.data

import com.aakulovaa.vkedu.domain.AppDetails
import com.aakulovaa.vkedu.domain.AppDetailsRepository

class AppDetailsRepositoryImpl(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsApi
) : AppDetailsRepository {
    override suspend fun getAppDetails(id: String): AppDetails {
        val dto = api.getAppDetails(id)
        return mapper.appDetailsToDomain(dto)
    }
}