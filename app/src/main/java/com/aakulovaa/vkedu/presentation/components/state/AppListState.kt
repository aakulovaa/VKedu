package com.aakulovaa.vkedu.presentation.components.state

import com.aakulovaa.vkedu.data.models.AppListItem

sealed interface AppListState {
    data object Loading: AppListState
    data object Error: AppListState
    data class AppListContent(
        val apps: List<AppListItem>
    ) : AppListState
}