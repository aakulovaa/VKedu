package com.aakulovaa.vkedu.data.api

import com.aakulovaa.vkedu.data.dto.AppListItemDto
import retrofit2.http.GET

interface AppListApi {
    @GET("catalog")
    suspend fun getAppList(): List<AppListItemDto>
}