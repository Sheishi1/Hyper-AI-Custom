package com.hyper.customai.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

fun formatedGeminiText(geminiText: String): AnnotatedString {
    val formattedText = buildAnnotatedString {
        val lines = geminiText.split("\n")

        for (line in lines) {
            when {
                line.startsWith("# ") -> {
                    append(line.removePrefix("# ") + "\n\n")
                }
                line.startsWith("## ") -> {
                    append(line.removePrefix("## ") + "\n\n")
                }
                line.startsWith("* ") -> {
                    append(line.removePrefix("* ") + "\n")
                }
                line.matches(Regex("\\d+\\. .*")) -> {
                    append(line + "\n")
                }
                line.startsWith("[") && line.contains("](") -> {
                    val start = line.indexOf("[") + 1
                    val end = line.indexOf("](")
                    append(line.substring(start, end) + "\n")
                }
                line.startsWith("`") && line.endsWith("`") -> {
                    append(line + "\n")
                }
                line.startsWith("```") -> {
                }
                else -> {
                    append(line + "\n")
                }
            }
        }
    }

    return formattedText
}