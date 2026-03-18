package com.aakulovaa.vkedu.domain.useCase

import com.aakulovaa.vkedu.domain.model.AppListItem
import com.aakulovaa.vkedu.domain.repository.AppListRepository

class GetAppListUseCase(
    private val repository: AppListRepository
) {
    suspend operator fun invoke(): List<AppListItem> {
        return repository.getAppList()
    }
}