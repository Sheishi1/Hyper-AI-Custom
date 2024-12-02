package com.hyper.customai.domain.model

import com.hyper.customai.data.remote.dto.GeminiMessageDto
import com.hyper.customai.data.remote.dto.GeminiRequestMessageDto
import com.hyper.customai.data.remote.dto.Part
import com.hyper.customai.data.remote.dto.RequestContent

data class GeminiRequestMessage(
    val message: String
)

fun GeminiRequestMessage.toGeminiRequestMessageDto() = GeminiRequestMessageDto(
    contents = RequestContent(parts = listOf(Part(text = message)))
)
