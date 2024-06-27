package com.example.nbcchallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Badge(modifier: Modifier, labelBadge: String) {
    Text(
        text = labelBadge,
        color = Color.DarkGray,
        modifier = modifier
            .background(color = Color.White)
            .padding(horizontal = 4.dp, vertical = 4.dp)
    )
}