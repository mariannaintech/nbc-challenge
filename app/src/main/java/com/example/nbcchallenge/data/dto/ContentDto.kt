package com.example.nbcchallenge.data.dto

import com.google.gson.annotations.SerializedName

data class ContentDto(
    @SerializedName("type") val type: String,
    @SerializedName("tagline") val tagline: String?,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String?,
    @SerializedName("image") val image: String,
    @SerializedName("labelBadge") val labelBadge: String?,
)
