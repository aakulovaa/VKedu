package com.aakulovaa.vkedu.domain.repository

import com.aakulovaa.vkedu.domain.model.AppDetails

interface AppDetailsRepository {
    suspend fun getAppDetails(id: String): AppDetails
}