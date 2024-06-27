package com.example.nbcchallenge.data.mapper

import com.example.nbcchallenge.data.dto.ContentDto
import com.example.nbcchallenge.data.dto.HomePageDto
import com.example.nbcchallenge.data.dto.ShelfDto
import com.example.nbcchallenge.domain.models.EpisodeItem
import com.example.nbcchallenge.domain.models.HomePageInfo
import com.example.nbcchallenge.domain.models.LiveItem
import com.example.nbcchallenge.domain.models.ShelfInfo
import com.example.nbcchallenge.domain.models.ShowItem

private const val TYPE_EPISODE = "Episode"
private const val TYPE_SHOW = "Show"
private const val TYPE_LIVE = "Live"

fun HomePageDto.toDomain() = HomePageInfo(
    page = page,
    shelves = shelves.shelfToDomain()
)

fun ShelfDto.toDomain() = ShelfInfo(
    title = title,
    type = type,
    items = items.listToDomain()
)

fun ContentDto.toDomain() = when (type) {
    TYPE_LIVE -> LiveItem(
        type = type,
        title = title,
        subtitle = subtitle.orEmpty(),
        image = image,
        tagline = tagline.orEmpty()
    )

    TYPE_EPISODE -> EpisodeItem(
        type = type,
        title = title,
        subtitle = subtitle.orEmpty(),
        image = image,
        labelBadge = labelBadge.orEmpty()
    )

    TYPE_SHOW -> ShowItem(
        type = type,
        title = title,
        image = image
    )

    else -> error("unexpected content type $type")
}

fun List<ShelfDto>.shelfToDomain() = map { it.toDomain() }

fun List<ContentDto>.listToDomain() = map { it.toDomain() }