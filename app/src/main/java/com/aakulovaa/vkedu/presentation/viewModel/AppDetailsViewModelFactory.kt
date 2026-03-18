package com.aakulovaa.vkedu.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aakulovaa.vkedu.domain.GetAppDetailsUseCase

@Suppress("UNCHECKED_CAST")
class AppDetailsViewModelFactory(
    private val idAppDetails: String,
    private val getAppDetailsUseCase: GetAppDetailsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppDetailsViewModel::class.java)){
            return AppDetailsViewModel(idAppDetails, getAppDetailsUseCase) as T
        }
        throw IllegalArgumentException("ошибка ViewModel")
    }
}