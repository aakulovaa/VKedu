package com.aakulovaa.vkedu

object Routes {
    const val APP_LIST = "app_list"
    const val APP_DETAILS = "app_details"

    fun appDetails(title: String) = "$APP_DETAILS/$title"
}