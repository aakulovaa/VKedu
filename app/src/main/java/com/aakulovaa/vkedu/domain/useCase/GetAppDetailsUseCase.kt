package com.aakulovaa.vkedu.domain.useCase

import com.aakulovaa.vkedu.domain.model.AppDetails
import com.aakulovaa.vkedu.domain.repository.AppDetailsRepository
import kotlinx.coroutines.flow.Flow

class GetAppDetailsUseCase(
    private val repository: AppDetailsRepository
) {
    suspend operator fun invoke(id: String): AppDetails {
        return repository.getAppDetails(id)
    }

    suspend fun toggleWishlist(id: String) {
        repository.toggleWishlist(id)
    }

    fun observeAppDetails(id: String): Flow<AppDetails> {
        return repository.observeAppDetails(id)
    }
}