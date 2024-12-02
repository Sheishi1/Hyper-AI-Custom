package com.hyper.customai.data.remote.dto

import com.hyper.customai.domain.model.GeminiMessage
import kotlinx.serialization.Serializable

@Serializable
data class GeminiMessageDto(
    val candidates: List<Candidate>,
    val usageMetadata: UsageMetadata,
    val modelVersion: String
)

@Serializable
data class Candidate(
    val content: Content,
    val finishReason: String,
    val avgLogprobs: Double
)

@Serializable
data class Content(
    val parts: List<Part>,
    val role: String
)

@Serializable
data class Part(
    val text: String
)

@Serializable
data class UsageMetadata(
    val promptTokenCount: Int,
    val candidatesTokenCount: Int,
    val totalTokenCount: Int
)

fun GeminiMessageDto.toGeminiMessage(): GeminiMessage = GeminiMessage(
    message = candidates[0].content.parts[0].text
)