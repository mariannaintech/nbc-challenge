package com.example.nbcchallenge.data.dto

import com.google.gson.annotations.SerializedName

data class HomePageDto(
    @SerializedName("page") val page: String,
    @SerializedName("shelves") val shelves: List<ShelfDto>,
)
