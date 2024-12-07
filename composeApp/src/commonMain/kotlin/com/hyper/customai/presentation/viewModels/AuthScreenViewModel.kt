package com.hyper.customai.presentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyper.customai.domain.useCase.dataStoreUseCases.UserDataStoreUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class AuthScreenViewModel(
    private val userDataStoreUseCase: UserDataStoreUseCase
): ViewModel() {
    var apiToken by mutableStateOf<String>("")

    init {
        viewModelScope.launch {
            apiToken = userDataStoreUseCase.getApiToken().first()
        }
    }

    fun saveApiToken(token: String) {
        viewModelScope.launch {
            try {
                userDataStoreUseCase.saveApiToken(token)
            } catch (e: Exception) {
                println("saveApiTokenError: $e")
            }
        }
    }

    fun logOut() {
        viewModelScope.launch {
            userDataStoreUseCase.saveApiToken("")
        }
    }
}