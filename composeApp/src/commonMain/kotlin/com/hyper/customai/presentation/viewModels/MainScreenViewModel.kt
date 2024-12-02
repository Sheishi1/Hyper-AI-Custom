package com.hyper.customai.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyper.customai.common.Resource
import com.hyper.customai.domain.model.GeminiRequestMessage
import com.hyper.customai.domain.useCase.getGeminiMessage.GetGeminiMessageUseCase
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getGeminiMessageUseCase: GetGeminiMessageUseCase
) : ViewModel() {
    private val _geminiMessage = MutableStateFlow<Resource<String>>(Resource.Loading)
    val geminiMessage: StateFlow<Resource<String>> = _geminiMessage.asStateFlow()

    fun getResponse(
        value: String,
        token: String = "AIzaSyDM6dlhVJTS3UNDUV4FtMKJP9g0wvuc12E"
    ) {
        getGeminiMessageUseCase(
            message = GeminiRequestMessage(value),
            token = token
        ).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _geminiMessage.value = Resource.Success(result.data.message)
                }

                is Resource.Loading -> {
                    _geminiMessage.value = Resource.Loading
                }

                is Resource.Error -> {
                    _geminiMessage.value =
                        Resource.Error(message = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }
}