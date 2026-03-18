package com.aakulovaa.vkedu.presentation.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aakulovaa.vkedu.domain.useCase.GetAppListUseCase

@Suppress("UNCHECKED_CAST")
class AppListViewModelFactory(
    private val getAppListUseCase: GetAppListUseCase,
    private val application: Application
) : ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppListViewModel::class.java)) {
            return AppListViewModel(getAppListUseCase, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}