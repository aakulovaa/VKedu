package com.aakulovaa.vkedu.data

import kotlinx.coroutines.delay

class AppDetailsApi {
    suspend fun getAppDetails(id: String): AppDetailsDto{
        delay(2000L)
        return appDetailsData.first{ it.id == id}
    }

    private val appDetailsData = listOf(
        AppDetailsDto(
            id = "1",
            title = "СберБанк Онлайн — с Салютом",
            developer = "Сбербанк",
            description = "Больше чем банк",
            category = "Финансы",
            iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png",
            ageRating = 3,
            size = 150.3f,
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/YAyMfd1C5Y4ADB-81F4yT0rqc7hoSOkMOyTXTyXkG60/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/19/e2/apk/462271/content/SCREENSHOT/af9920e4-eb9a-45d7-9224-ada17e9fad94.png@webp",
                "https://static.rustore.ru/imgproxy/ueOMCvH3fqGWDCmSF009YQq_6JMq7UMhSWbAcOEwZBA/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/19/e8/apk/462271/content/SCREENSHOT/fd8a50aa-7485-4d53-abb4-753098690a0a.png@webp",
                "https://static.rustore.ru/imgproxy/PQYAfC-o3rQRJIZ-yLHT-e326EgH0k7eKAP9KcMV6vI/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/19/f9/apk/462271/content/SCREENSHOT/29ad8437-5651-40fa-9f06-a4ec77b7da71.png@webp",
                "https://static.rustore.ru/imgproxy/0Ah_0lEHsExVLrIoZ4aNxke42571sz8zUX7cMRB9auE/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/19/8a/apk/462271/content/SCREENSHOT/cf3fb659-7731-424e-b1ed-f0bdfeacf6d0.png@webp",
            )
        ),

        AppDetailsDto(
            id = "2",
            title = "Яндекс.Браузер — с Алисой",
            developer = "Яндекс",
            description = "Быстрый и безопасный браузер",
            category = "Инструменты",
            iconUrl = "https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png",
            ageRating = 3,
            size = 95.8f,
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/PFLM-GlJd_frNCL5vR_OJZZQhzdL3fvgdvIdpJrVq4A/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/25/6a/apk/579007/content/SCREENSHOT/b14e7901-1fcb-4045-94af-3464c359f224.jpg@webp",
                "https://static.rustore.ru/imgproxy/Au3P2Niy_5KX1We1FiE018ua2_ESFPF4ojmIq8hLrew/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/25/bc/apk/579007/content/SCREENSHOT/eb4422a7-36cf-4d11-a25a-456026f39cc7.jpg@webp",
                "https://static.rustore.ru/imgproxy/Fs5c_h_5CDN9x08e-7hwqtRjLp-SHCktgtEr54qUfEE/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/25/81/apk/579007/content/SCREENSHOT/1d9d8a7f-9d6d-4b53-9107-c379bbd1ce48.jpg@webp",
                "https://static.rustore.ru/imgproxy/wAYoW7mF9FERBTTrYt6bEodhDIRSa8WZIcgYfGk3oxU/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/25/b3/apk/579007/content/SCREENSHOT/816a1cc0-31aa-431f-a560-51aad66f7342.jpg@webp",
            )
        ),

        AppDetailsDto(
            id = "3",
            title = "Почта Mail.ru",
            developer = "Mail.ru",
            description = "Почтовый клиент для любых ящиков",
            category = "Инструменты",
            iconUrl = "https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png",
            ageRating = 3,
            size = 82.1f,
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/MQs3o-5t7FMY6518WgSpCbFGZF-H-n1_ql8jqNWH6Es/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/3/11/45/apk/332223/content/SCREENSHOT/10dea749-03a5-42d7-84f1-ef69c46915ce.png@webp",
                "https://static.rustore.ru/imgproxy/PVXMk77p7BzWEMiJFrs6dtFhKESK8QaFi7tm3QYnX3A/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/3/11/aa/apk/332223/content/SCREENSHOT/40de5dfa-f822-49df-b613-d0ebd78bd518.png@webp",
                "https://static.rustore.ru/imgproxy/Ffcz9t8LBCAVtEQGCTeKv-vbchC3dxgv6CLAwNoQnr0/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/3/11/78/apk/332223/content/SCREENSHOT/929a7b92-d82a-4b93-b196-da95ae27c9e2.png@webp",
                "https://static.rustore.ru/imgproxy/bTD_N6d6xuPH8PxCs-WYm6g6wJq1N8EnShtUcbPksiw/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/3/11/4b/apk/332223/content/SCREENSHOT/025e2e58-7a52-470f-96da-678e7ac7aeac.png@webp",
            )
        ),

        AppDetailsDto(
            id = "4",
            title = "Яндекс Навигатор",
            developer = "Яндекс",
            description = "Парковки и заправки — по пути",
            category = "Транспорт и навигация",
            iconUrl = "https://static.rustore.ru/apk/595135/content/ICON/32cb5e63-9c59-4280-9a6a-c808113be88f.png",
            ageRating = 3,
            size = 110.4f,
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/TN6h0GZmMbN8iD4C-Me_aY1u0zJAztbmxHixGj4RWzk/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/3/5/ce/apk/595135/content/SCREENSHOT/d74ff81a-6bbb-41ff-b26a-7c6d468267c2.jpg@webp",
                "https://static.rustore.ru/imgproxy/gdeWlZnQ1g3xq318M4EKsQOueNr1j63Wlf5yxPex5T0/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/595135/content/SCREENSHOT/916f577b-318c-4ab4-8795-5b8a576c2268.png@webp",
                "https://static.rustore.ru/imgproxy/UlclcZ6985JyyVANl4pce7OL2bixodYoo2A6RUqv_X0/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/595135/content/SCREENSHOT/1600ea6e-628d-404c-9c4f-a963afcc4e30.png@webp",
                "https://static.rustore.ru/imgproxy/lMwYnk4ZDAl7xRVXeHXQ6hUbw02PJFjTYzw2zD4t4mw/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/595135/content/SCREENSHOT/1bdbb031-5ad3-4001-915f-e027a7b72de6.png@webp",
            )
        ),

        AppDetailsDto(
            id = "5",
            title = "Мой МТС",
            developer = "МТС",
            description = "Мой МТС — центр экосистемы МТС",
            category = "Инструменты",
            iconUrl = "https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png",
            ageRating = 3,
            size = 120.7f,
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/xl-HfeCOmitsR6TCh5doWAMQnpjkh7KvuPOG30C3vI8/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/12/15/ce/apk/336831/content/SCREENSHOT/e3558c77-1ca4-42e2-ad1b-e086fbf1e23a.jpg@webp",
                "https://static.rustore.ru/imgproxy/2IxCqrjbN7PLDHmONt_Xne0GEYO4PmNiy8NDbB5-F2k/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/12/15/bb/apk/336831/content/SCREENSHOT/dea85320-baab-4b65-9aab-cda9b7e09505.jpg@webp",
                "https://static.rustore.ru/imgproxy/gGGYntEcgHwHqeGhJPPBQw7if4Kj_ZmFLSRZ9OwRrAA/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/12/15/8b/apk/336831/content/SCREENSHOT/32a77bf1-e88b-4845-8b9e-59f0db26c94a.jpg@webp",
                "https://static.rustore.ru/imgproxy/iod1zwq8sElW9CuTOKZqczkWg5oxYvOhTx08twM4QHo/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/12/15/7b/apk/336831/content/SCREENSHOT/3daa554d-e308-4540-8976-1d9d93bf5e10.jpg@webp",
            )
        ),

        AppDetailsDto(
            id = "6",
            title = "Яндекс — с Алисой",
            developer = "Яндекс",
            description = "Яндекс — поиск всегда под рукой",
            category = "Инструменты",
            iconUrl = "https://static.rustore.ru/apk/313257919/content/ICON/843c5040-0e09-41bb-958c-b7bacc912c2b.png",
            ageRating = 3,
            size = 101.9f,
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/R_tObRV6q3c-MKTKMVlJu88Iio7UFjrtOC3GQuSJMrE/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/20/f1/apk/313257919/content/SCREENSHOT/cb6a4a05-0905-4b97-b182-20eab3274d00.jpg@webp",
                "https://static.rustore.ru/imgproxy/BazuNZK9F9jeyaWArRwiQR4CTZ5bz8MlPiL2Na046gg/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/20/bd/apk/313257919/content/SCREENSHOT/d7b2081b-f9ba-471d-a9df-9e7c6336c22d.jpg@webp",
                "https://static.rustore.ru/imgproxy/dImHj9dMH-vnMTXeMiWLDAhy2Wa8PTzbHQgfHjLFRs8/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/20/3a/apk/313257919/content/SCREENSHOT/905b5654-1384-46fd-85c8-f997cc8f0988.jpg@webp",
                "https://static.rustore.ru/imgproxy/IZlLXRNigHEc6NA4peAr0MelaahDf7wzE8DftBLzE9Y/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/20/80/apk/313257919/content/SCREENSHOT/4c13286d-1748-49ce-80cd-18d090f6a3cb.jpg@webp",
            )
        )
    )
}