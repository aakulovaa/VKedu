package com.aakulovaa.vkedu.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.aakulovaa.vkedu.R
import com.aakulovaa.vkedu.domain.useCase.GetAppListUseCase
import com.aakulovaa.vkedu.presentation.viewModel.state.AppListState
import com.aakulovaa.vkedu.presentation.viewModel.state.SnackState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AppListViewModel(
    private val getAppListUseCase: GetAppListUseCase,
    application: Application
): AndroidViewModel(application) {
    private val _state: MutableStateFlow<AppListState> = MutableStateFlow(AppListState.Loading)
    val state: StateFlow<AppListState> = _state.asStateFlow()

    private val _snack = Channel<SnackState>(
        Channel.BUFFERED
    )
    val snack = _snack.receiveAsFlow()

    fun onLogoClick(){
        val message = getApplication<Application>().getString(R.string.snack_message)
        viewModelScope.launch {
            _snack.send(
                SnackState.ShowSnackbar(message)
            )
        }
    }

    init {
        loadAppList()
    }

    fun loadAppList(){
        viewModelScope.launch {
            runCatching {
                _state.value = AppListState.Loading
                val apps = getAppListUseCase()
                _state.value = AppListState.AppListContent(apps)
            }.onFailure {
                _state.value = AppListState.Error
            }
        }
    }

}