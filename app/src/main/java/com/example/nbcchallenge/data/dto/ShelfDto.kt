package com.example.nbcchallenge.data.dto

import com.google.gson.annotations.SerializedName

data class ShelfDto(
    @SerializedName("title") val title: String,
    @SerializedName("type") val type: String,
    @SerializedName("items") val items: List<ContentDto>,
)
