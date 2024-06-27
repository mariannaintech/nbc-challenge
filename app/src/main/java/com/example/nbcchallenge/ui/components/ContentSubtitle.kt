package com.example.nbcchallenge.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun ContentSubtitle(subtitle: String) {
    Text(
        text = subtitle,
        fontSize = 14.sp,
        color = Color.LightGray,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}