package com.aakulovaa.vkedu.domain.useCase

import com.aakulovaa.vkedu.domain.model.AppDetails
import com.aakulovaa.vkedu.domain.repository.AppDetailsRepository

class GetAppDetailsUseCase(
    private val repository: AppDetailsRepository
) {
    suspend operator fun invoke(id: String): AppDetails {
        return repository.getAppDetails(id)
    }
}