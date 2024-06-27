package com.example.nbcchallenge.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShelfTitle(title: String) {
    Text(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp),
        text = title,
        color = Color.White,
        maxLines = 2,
        lineHeight = 24.sp,
        overflow = TextOverflow.Ellipsis,
        fontSize = 18.sp
    )
}