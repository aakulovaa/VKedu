package com.aakulovaa.vkedu.presentation.components.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.aakulovaa.vkedu.R
import com.aakulovaa.vkedu.data.models.AppListItem
import com.aakulovaa.vkedu.data.models.Category
import com.aakulovaa.vkedu.presentation.components.state.AppListState
import com.aakulovaa.vkedu.presentation.components.state.SnackState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AppListViewModel(application: Application): AndroidViewModel(application) {
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
                delay(2000L)
                val apps = getListApp()
                _state.value = AppListState.AppListContent(apps)
            }.onFailure {
                _state.value = AppListState.Error
            }
        }
    }

    fun getListApp(): List<AppListItem> {
        return listOf(
            AppListItem(
                title = "СберБанк Онлайн — с Салютом",
                description = "Больше чем банк",
                category = Category.FINANCE,
                iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png",
                ),
            AppListItem(
                title = "Яндекс.Браузер — с Алисой",
                description = "Быстрый и безопасный браузер",
                category = Category.TOOLS,
                iconUrl = "https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png",
            ),
            AppListItem(
                title = "Почта Mail.ru",
                description = "Почтовый клиент для любых ящиков",
                category = Category.TOOLS,
                iconUrl = "https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png",
            ),
            AppListItem(
                title = "Яндекс Навигатор",
                description = "Парковки и заправки — по пути",
                category = Category.TRANSPORT,
                iconUrl = "https://static.rustore.ru/apk/595135/content/ICON/32cb5e63-9c59-4280-9a6a-c808113be88f.png",
            ),
            AppListItem(
                title = "Мой МТС",
                description = "Мой МТС — центр экосистемы МТС",
                category = Category.TOOLS,
                iconUrl = "https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png",
            ),
            AppListItem(
                title = "Яндекс — с Алисой",
                description = "Яндекс — поиск всегда под рукой",
                category = Category.TOOLS,
                iconUrl = "https://static.rustore.ru/apk/313257919/content/ICON/843c5040-0e09-41bb-958c-b7bacc912c2b.png",
            )
        )
    }
}