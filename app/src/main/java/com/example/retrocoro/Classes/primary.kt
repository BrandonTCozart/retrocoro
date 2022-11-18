package com.example.retrocoro.Classes

data class primary(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<result>,
    val totalCount: Int,
    val totalPages: Int
)