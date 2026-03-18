package com.aakulovaa.vkedu.data.repositoryImpl

import com.aakulovaa.vkedu.data.api.AppListApi
import com.aakulovaa.vkedu.data.mappers.AppListMapper
import com.aakulovaa.vkedu.domain.model.AppListItem
import com.aakulovaa.vkedu.domain.repository.AppListRepository

class AppListRepositoryImpl(
    private val mapper: AppListMapper,
    private val api: AppListApi
) : AppListRepository {
    override suspend fun getAppList(): List<AppListItem> {
        return api.getAppList().map { dto -> mapper.appListToDomain(dto)}
    }
}