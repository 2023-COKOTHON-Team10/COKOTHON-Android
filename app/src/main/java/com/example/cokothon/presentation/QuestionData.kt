package com.example.cokothon.presentation

data class QuestionData(
    var contents: String,
    val user_id: Long,
    val type: String,
    var choice1: String,
    var choice1_bool: Boolean,
    var choice2: String,
    var choice2_bool: Boolean,
    var choice3: String,
    var choice3_bool: Boolean,
    var choice4: String,
    var choice4_bool: Boolean
)