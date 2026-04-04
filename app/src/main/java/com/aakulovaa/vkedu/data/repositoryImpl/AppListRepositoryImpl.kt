package com.aakulovaa.vkedu.data.repositoryImpl

import com.aakulovaa.vkedu.data.api.AppListApi
import com.aakulovaa.vkedu.data.mappers.AppListMapper
import com.aakulovaa.vkedu.domain.model.AppListItem
import com.aakulovaa.vkedu.domain.repository.AppListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppListRepositoryImpl(
    private val mapper: AppListMapper,
    private val api: AppListApi
) : AppListRepository {
    override suspend fun getAppList(): List<AppListItem> = withContext(Dispatchers.IO) {
        api.getAppList().map {
            mapper.appListToDomain(it)
        }
    }
}