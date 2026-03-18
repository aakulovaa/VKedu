package com.aakulovaa.vkedu.data.api

import com.aakulovaa.vkedu.data.dto.AppListItemDto
import kotlinx.coroutines.delay

class AppListApi {
    suspend fun getAppList(): List<AppListItemDto> {
        delay(2000L)
        return appListData
    }

    private val appListData = listOf(
        AppListItemDto(
            id = "1",
            title = "СберБанк Онлайн — с Салютом",
            description = "Больше чем банк",
            category = "Финансы",
            iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png",
        ),
        AppListItemDto(
            id = "2",
            title = "Яндекс.Браузер — с Алисой",
            description = "Быстрый и безопасный браузер",
            category = "Инструменты",
            iconUrl = "https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png",
        ),
        AppListItemDto(
            id = "3",
            title = "Почта Mail.ru",
            description = "Почтовый клиент для любых ящиков",
            category = "Инструменты",
            iconUrl = "https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png",
        ),
        AppListItemDto(
            id = "4",
            title = "Яндекс Навигатор",
            description = "Парковки и заправки — по пути",
            category = "Транспорт и навигация",
            iconUrl = "https://static.rustore.ru/apk/595135/content/ICON/32cb5e63-9c59-4280-9a6a-c808113be88f.png",
        ),
        AppListItemDto(
            id = "5",
            title = "Мой МТС",
            description = "Мой МТС — центр экосистемы МТС",
            category = "Инструменты",
            iconUrl = "https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png",
        ),
        AppListItemDto(
            id = "6",
            title = "Яндекс — с Алисой",
            description = "Яндекс — поиск всегда под рукой",
            category = "Инструменты",
            iconUrl = "https://static.rustore.ru/apk/313257919/content/ICON/843c5040-0e09-41bb-958c-b7bacc912c2b.png",
        )
    )
}