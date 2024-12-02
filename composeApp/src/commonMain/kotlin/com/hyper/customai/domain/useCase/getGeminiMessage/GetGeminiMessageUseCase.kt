package com.hyper.customai.domain.useCase.getGeminiMessage

import com.hyper.customai.common.Resource
import com.hyper.customai.data.remote.dto.GeminiErrorDto
import com.hyper.customai.data.remote.dto.GeminiMessageDto
import com.hyper.customai.data.remote.dto.toGeminiMessage
import com.hyper.customai.domain.model.GeminiMessage
import com.hyper.customai.domain.model.GeminiRequestMessage
import com.hyper.customai.domain.model.toGeminiRequestMessageDto
import com.hyper.customai.domain.repository.GeminiApiRepository
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class GetGeminiMessageUseCase(private val repository: GeminiApiRepository) {
    private val json = Json { ignoreUnknownKeys = true }

    operator fun invoke(message: GeminiRequestMessage, token: String): Flow<Resource<GeminiMessage>> = flow {
        try {
            emit(Resource.Loading)

            val response = repository.postGeminiMessage(
                body = message.toGeminiRequestMessageDto(),
                token = token
            )
            if (response.status.isSuccess()) {
                emit(Resource.Success(json.decodeFromString<GeminiMessageDto>(response.bodyAsText()).toGeminiMessage()))
            } else {
                emit(Resource.Error(message = json.decodeFromString<GeminiErrorDto>(response.bodyAsText()).error.message))
            }
        } catch (t: Throwable) {
            emit(Resource.Error(message = t.message ?: "Unknown error"))
        }
    }
}