package com.example.cokothon.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseExampleDto(
    @SerialName("test")
    val test: String
)
