package com.example.portal.data.model

data class Question(
    val id: String,
    val paper: String,
    val question: String,
    val options: List<QuestionOption>
)