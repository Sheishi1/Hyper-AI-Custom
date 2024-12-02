package com.hyper.customai.domain.repository

import com.hyper.customai.data.remote.dto.GeminiMessageDto
import com.hyper.customai.data.remote.dto.GeminiRequestMessageDto
import io.ktor.client.statement.HttpResponse

interface GeminiApiRepository {
    suspend fun postGeminiMessage(body: GeminiRequestMessageDto, token: String): HttpResponse
}