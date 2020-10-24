package com.example.portal.data.model

data class Paper(
    val id: String,
    val code: String,
    val title: String,
    val session: String,
    val semester: Int,
    val date: String,
    val time: String,
    val duration: Int
)