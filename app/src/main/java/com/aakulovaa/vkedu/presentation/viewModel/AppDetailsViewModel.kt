package com.aakulovaa.vkedu.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aakulovaa.vkedu.domain.useCase.GetAppDetailsUseCase
import com.aakulovaa.vkedu.presentation.viewModel.state.AppDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getAppDetailsUseCase: GetAppDetailsUseCase
) : ViewModel() {

    private val idAppDetails: String = checkNotNull(savedStateHandle["idAppDetails"])
    private val _state: MutableStateFlow<AppDetailsState> = MutableStateFlow(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            loadAppDetails()
            observeAppDetails()
        }
    }

     private fun loadAppDetails(){
         viewModelScope.launch {
             runCatching {
                 getAppDetailsUseCase(idAppDetails)
             }.onFailure {
                 _state.value = AppDetailsState.Error
             }
         }
    }

    fun toggleWishlist(){
        viewModelScope.launch {
            getAppDetailsUseCase.toggleWishlist(idAppDetails)
        }
    }

    private fun observeAppDetails() {
        getAppDetailsUseCase.observeAppDetails(idAppDetails)
            .onEach { appDetails ->
                _state.value = AppDetailsState.Content(appDetails)
            }
            .catch {
                _state.value = AppDetailsState.Error
            }
            .launchIn(viewModelScope)
    }

}