package com.aakulovaa.vkedu.data.mappers

import com.aakulovaa.vkedu.domain.model.Category

class CategoryMapper {
    fun toDomain(category: String): Category = when(category){
        "Бизнес" -> Category.BUSINESS
        "Еда и напитки" -> Category.FOODDRINK
        "Здоровье и фитнес" -> Category.FITNESS
        "Игры" -> Category.GAMES
        "Инструменты" -> Category.TOOLS
        "Книги и справочники" -> Category.BOOKS
        "Музыка" -> Category.MUSIC
        "Навигация" -> Category.NAVIGATION
        "Новости" -> Category.NEWS
        "Образ жизни" -> Category.LIFESTYLE
        "Образование" -> Category.EDUCATION
        "Общение" -> Category.SOCIAL
        "Погода" -> Category.WEATHER
        "Производительность" -> Category.PRODUCTIVITY
        "Развлечения" -> Category.ENTERTAINMENTS
        "Транспорт и навигация" -> Category.TRANSPORT
        "Утилиты" -> Category.UTILITIES
        "Фото и видео" -> Category.PHOTO
        "Финансы" -> Category.FINANCE
        "Шопинг" -> Category.SHOPPING
        else -> Category.UNKNOWN
    }
}