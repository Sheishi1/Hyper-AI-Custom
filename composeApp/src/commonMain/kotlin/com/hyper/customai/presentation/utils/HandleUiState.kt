package com.hyper.customai.presentation.utils

sealed class HandleUiState<out T> {
    data object None : HandleUiState<Nothing>()
    data object Loading : HandleUiState<Nothing>()
    data class Success<T>(val data: T) : HandleUiState<T>()
    data class Error(val message: String, val retryAction: (suspend () -> Unit)? = null) : HandleUiState<Nothing>()
}