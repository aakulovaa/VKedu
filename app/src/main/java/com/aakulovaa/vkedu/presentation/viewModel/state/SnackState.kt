package com.aakulovaa.vkedu.presentation.viewModel.state

sealed interface SnackState {
    data class ShowSnackbar(
        val message: String
    ) : SnackState
}