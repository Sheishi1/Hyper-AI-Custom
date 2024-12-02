package com.hyper.customai.data.repository

import com.hyper.customai.common.Constants.GEMINI_API
import com.hyper.customai.data.remote.dto.GeminiMessageDto
import com.hyper.customai.data.remote.dto.GeminiRequestMessageDto
import com.hyper.customai.domain.repository.GeminiApiRepository
import hyperai_custom.composeapp.generated.resources.Res
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

class GeminiApiRepositoryImpl(private val httpClient: HttpClient): GeminiApiRepository {
    override suspend fun postGeminiMessage(body: GeminiRequestMessageDto, token: String): HttpResponse {
        return httpClient.post {
            url(GEMINI_API)
            parameter("key", token)
            header("Content-Type", "application/json")
            setBody(body)
        }
    }
}