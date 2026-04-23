package com.aakulovaa.vkedu.data.api

import com.aakulovaa.vkedu.data.dto.AppDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AppDetailsApi {
    @GET("catalog/{id}")
    suspend fun getAppDetails(@Path("id") id: String): AppDetailsDto
}