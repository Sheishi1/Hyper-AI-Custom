package com.hyper.customai.data.dataStore

import com.hyper.customai.domain.repository.UserDataStoreRepository
import kotlinx.coroutines.flow.Flow

actual class UserDataStore : UserDataStoreRepository {
    override suspend fun getToken(): Flow<String> {
        TODO("Not yet implemented")
    }

    override suspend fun saveToken(token: String) {
        TODO("Not yet implemented")
    }

}