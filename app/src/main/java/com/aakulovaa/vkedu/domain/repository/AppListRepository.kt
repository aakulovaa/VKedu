package com.aakulovaa.vkedu.domain.repository

import com.aakulovaa.vkedu.domain.model.AppListItem

interface AppListRepository {
    suspend fun getAppList(): List<AppListItem>
}