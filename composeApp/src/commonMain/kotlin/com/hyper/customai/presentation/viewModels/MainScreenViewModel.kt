package com.hyper.customai.presentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyper.customai.common.Resource
import com.hyper.customai.domain.model.GeminiRequestMessage
import com.hyper.customai.domain.useCase.dataStoreUseCases.UserDataStoreUseCase
import com.hyper.customai.domain.useCase.getGeminiMessage.GetGeminiMessageUseCase
import com.hyper.customai.presentation.utils.HandleUiState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication.Companion.init

class MainScreenViewModel(
    private val getGeminiMessageUseCase: GetGeminiMessageUseCase,
    private val userDataStoreUseCase: UserDataStoreUseCase
) : ViewModel() {
    var apiToken by mutableStateOf("")

    init {
        viewModelScope.launch {
            apiToken = userDataStoreUseCase.getApiToken().first()
        }
    }

    private val _geminiMessage = MutableStateFlow<HandleUiState<String>>(HandleUiState.None)
    val geminiMessage: StateFlow<HandleUiState<String>> = _geminiMessage.asStateFlow()

    fun getResponse(value: String) {
        getGeminiMessageUseCase(
            message = GeminiRequestMessage(value),
            token = apiToken
        ).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _geminiMessage.value = HandleUiState.Success(result.data.message)
                }

                is Resource.Loading -> {
                    _geminiMessage.value = HandleUiState.Loading
                }

                is Resource.Error -> {
                    _geminiMessage.value =
                        HandleUiState.Error(message = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }
}