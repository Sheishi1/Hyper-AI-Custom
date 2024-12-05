package com.hyper.customai.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserDataStoreRepository {
    suspend fun getToken(): Flow<String>
    suspend fun saveToken(token: String)
}