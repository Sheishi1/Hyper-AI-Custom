package com.hyper.customai.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.hyper.customai.data.repository.UserDataStoreRepositoryImpl.PreferencesKeys.API_TOKEN
import com.hyper.customai.domain.repository.UserDataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserDataStoreRepositoryImpl(private val dataStore: DataStore<Preferences>): UserDataStoreRepository {
    private object PreferencesKeys {
        val API_TOKEN = stringPreferencesKey("api_token")
    }

    override suspend fun getToken(): Flow<String> {
        return dataStore.data.map { it[API_TOKEN] ?: "" }
    }

    override suspend fun saveToken(token: String) {
        dataStore.edit { dataStore ->
            dataStore[API_TOKEN] = token
        }
    }
}