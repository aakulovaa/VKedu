package com.aakulovaa.vkedu.presentation.viewModel.state

import com.aakulovaa.vkedu.domain.model.AppDetails

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data object Error: AppDetailsState
    data class Content(
        val appDetails: AppDetails
    ) : AppDetailsState
}