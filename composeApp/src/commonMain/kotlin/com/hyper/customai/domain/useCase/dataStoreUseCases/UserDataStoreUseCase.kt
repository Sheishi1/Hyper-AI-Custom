package com.hyper.customai.domain.useCase.dataStoreUseCases

import com.hyper.customai.domain.repository.UserDataStoreRepository
import kotlinx.coroutines.flow.Flow

class UserDataStoreUseCase(private val repository: UserDataStoreRepository) {
    suspend fun getApiToken(): Flow<String> {
        return repository.getToken()
    }

    suspend fun saveApiToken(token: String) {
        repository.saveToken(token)
    }
}