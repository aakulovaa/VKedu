package com.aakulovaa.vkedu.domain

interface AppDetailsRepository {
    suspend fun getAppDetails(id: String): AppDetails
}