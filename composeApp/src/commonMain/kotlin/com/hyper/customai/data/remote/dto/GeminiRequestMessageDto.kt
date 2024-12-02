package com.hyper.customai.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GeminiRequestMessageDto(
    val contents: RequestContent
)

@Serializable
data class RequestContent(
    val parts: List<Part>
)