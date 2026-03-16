package com.aakulovaa.vkedu

import com.aakulovaa.vkedu.data.models.App
import com.aakulovaa.vkedu.data.models.AppListItem

fun App.toListItem(): AppListItem {
    return AppListItem(
        title = title,
        description = description,
        category = category,
        iconUrl = iconUrl
    )
}