package com.aakulovaa.vkedu

object Routes {
    const val APP_LIST = "app_list"
    const val APP_DETAILS = "app_details"

    fun appDetails(idAppDetails: String) = "$APP_DETAILS/$idAppDetails"
}