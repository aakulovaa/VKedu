package com.aakulovaa.vkedu.presentation.components.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class AppDetailsViewModelFactory(private val title: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppDetailsViewModel::class.java)){
            return AppDetailsViewModel(title) as T
        }
        throw IllegalArgumentException("ошибка ViewModel")
    }
}