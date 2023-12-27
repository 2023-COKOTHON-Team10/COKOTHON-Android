package com.example.cokothon.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestUserDto(
    @SerialName("name")
    val name: String,
)