package com.hyper.customai.common

sealed class Resource<out T> {
    data object Loading : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val statusCode: Int = 0, val message: String, val retryAction: (suspend () -> Unit)? = null) : Resource<Nothing>()
}
