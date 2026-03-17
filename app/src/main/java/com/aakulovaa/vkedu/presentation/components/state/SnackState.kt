package com.aakulovaa.vkedu.presentation.components.state

sealed interface SnackState {
    data class ShowSnackbar(
        val message: String
    ) : SnackState
}