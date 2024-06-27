package com.example.nbcchallenge.domain.models

data class ShelfInfo(
    val title: String,
    val type: String,
    val items: List<ContentItem>
)
