package com.aakulovaa.vkedu.domain

class GetAppDetailsUseCase(
    private val repository: AppDetailsRepository
) {
    suspend operator fun invoke(id: String): AppDetails{
        return repository.getAppDetails(id)
    }
}