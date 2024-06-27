package com.example.nbcchallenge.domain.models

import androidx.compose.runtime.Immutable

sealed class ContentItem {
    abstract val type: String
    abstract val title: String
    abstract val image: String
}

@Immutable
data class ShowItem(
    override val type: String,
    override val title: String,
    override val image: String,
) : ContentItem()

@Immutable
data class LiveItem(
    override val type: String,
    override val title: String,
    override val image: String,
    val tagline: String,
    val subtitle: String,
) : ContentItem()

@Immutable
data class EpisodeItem(
    override val type: String,
    override val title: String,
    override val image: String,
    val labelBadge: String,
    val subtitle: String,
) : ContentItem()