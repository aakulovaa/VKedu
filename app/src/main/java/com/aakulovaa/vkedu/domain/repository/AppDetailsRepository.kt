package com.aakulovaa.vkedu.domain.repository

import com.aakulovaa.vkedu.domain.model.AppDetails
import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    suspend fun getAppDetails(id: String): AppDetails

    suspend fun toggleWishlist(id: String)

    fun observeAppDetails(id: String): Flow<AppDetails>
}