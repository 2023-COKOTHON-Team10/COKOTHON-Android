package com.example.cokothon.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestUniqueNumDto(
    @SerialName("user_id")
    val userId: Long,
)