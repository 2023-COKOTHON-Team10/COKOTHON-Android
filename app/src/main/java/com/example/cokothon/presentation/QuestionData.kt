package com.example.cokothon.presentation

data class QuestionData(
    val contents: String,
    val user_id: Long,
    val type: String,
    val choice1: String,
    var choice1_bool: Boolean,
    val choice2: String,
    var choice2_bool: Boolean,
    val choice3: String,
    var choice3_bool: Boolean,
    val choice4: String,
    var choice4_bool: Boolean
)