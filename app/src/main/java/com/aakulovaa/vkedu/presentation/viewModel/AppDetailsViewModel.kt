package com.aakulovaa.vkedu.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aakulovaa.vkedu.domain.useCase.GetAppDetailsUseCase
import com.aakulovaa.vkedu.presentation.viewModel.state.AppDetailsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppDetailsViewModel(
    private val idAppDetails: String,
    private val getAppDetailsUseCase: GetAppDetailsUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<AppDetailsState> = MutableStateFlow(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    init {
        loadAppDetails()
    }

    fun loadAppDetails(){
        viewModelScope.launch {
            runCatching {
                _state.value = AppDetailsState.Loading
                val appDetail = getAppDetailsUseCase(idAppDetails)
                _state.value = AppDetailsState.Content(appDetail)
            }.onFailure {
                _state.value = AppDetailsState.Error
            }
        }
    }

}