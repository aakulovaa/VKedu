package com.aakulovaa.vkedu.presentation.components.state

import com.aakulovaa.vkedu.data.models.App

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data object Error: AppDetailsState
    data class Content(
        val appDetails: App?
    ) : AppDetailsState
}