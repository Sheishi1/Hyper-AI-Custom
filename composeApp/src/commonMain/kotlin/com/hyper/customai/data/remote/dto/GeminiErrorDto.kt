package com.hyper.customai.data.remote.dto

import com.hyper.customai.domain.model.GeminiError
import kotlinx.serialization.Serializable

@Serializable
data class GeminiErrorDto(
    val error: GeminiErrorObj
)

@Serializable
data class GeminiErrorObj(
    val code: Int,
    val message: String,
    val status: String
)

fun GeminiErrorDto.toGeminiError(): GeminiError = GeminiError(
    message = error.message
)