package com.aakulovaa.vkedu.presentation.viewModel.state

import com.aakulovaa.vkedu.domain.AppListItem

sealed interface AppListState {
    data object Loading: AppListState
    data object Error: AppListState
    data class AppListContent(
        val apps: List<AppListItem>
    ) : AppListState
}