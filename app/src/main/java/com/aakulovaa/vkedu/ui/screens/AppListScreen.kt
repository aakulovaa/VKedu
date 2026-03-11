package com.aakulovaa.vkedu.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aakulovaa.vkedu.data.models.App
import com.aakulovaa.vkedu.data.models.Category
import com.aakulovaa.vkedu.presentation.components.AppCard
import com.aakulovaa.vkedu.presentation.components.AppListScreenHeader
import com.aakulovaa.vkedu.ui.theme.Blue
import com.aakulovaa.vkedu.ui.theme.VKeduTheme


@Composable
fun AppListScreen(apps: List<App>){
    Column (modifier = Modifier.fillMaxSize().background(Blue)){

        AppListScreenHeader()

        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            color = Color.White
        ) {
            LazyColumn {
                items(apps) { app ->
                    AppCard(appItem = app)
                }
            }
        }

    }
}

@Preview
@Composable
private fun Preview(){
    val apps = listOf(
        App(
            title = "СберБанк Онлайн — с Салютом",
            developer = "Сбербанк",
            description = "Больше чем банк",
            category = Category.FINANCE,
            iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png",
            ageRating = 3,
            size = 150.3f,
            screenshotUrlList = emptyList()
        ),

        App(
            title = "Яндекс.Браузер — с Алисой",
            developer = "Яндекс",
            description = "Быстрый и безопасный браузер",
            category = Category.TOOLS,
            iconUrl = "https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png",
            ageRating = 3,
            size = 95.8f,
            screenshotUrlList = emptyList()
        ),

        App(
            title = "Почта Mail.ru",
            developer = "Mail.ru",
            description = "Почтовый клиент для любых ящиков",
            category = Category.TOOLS,
            iconUrl = "https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png",
            ageRating = 3,
            size = 82.1f,
            screenshotUrlList = emptyList()
        ),

        App(
            title = "Яндекс Навигатор",
            developer = "Яндекс",
            description = "Парковки и заправки — по пути",
            category = Category.TRANSPORT,
            iconUrl = "https://static.rustore.ru/apk/595135/content/ICON/32cb5e63-9c59-4280-9a6a-c808113be88f.png",
            ageRating = 3,
            size = 110.4f,
            screenshotUrlList = emptyList()
        ),

        App(
            title = "Мой МТС",
            developer = "МТС",
            description = "Мой МТС — центр экосистемы МТС",
            category = Category.TOOLS,
            iconUrl = "https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png",
            ageRating = 3,
            size = 120.7f,
            screenshotUrlList = emptyList()
        ),

        App(
            title = "Яндекс — с Алисой",
            developer = "Яндекс",
            description = "Яндекс — поиск всегда под рукой",
            category = Category.TOOLS,
            iconUrl = "https://static.rustore.ru/apk/313257919/content/ICON/843c5040-0e09-41bb-958c-b7bacc912c2b.png",
            ageRating = 3,
            size = 101.9f,
            screenshotUrlList = emptyList()
        )
    )

    VKeduTheme {
        AppListScreen(apps)
    }

}