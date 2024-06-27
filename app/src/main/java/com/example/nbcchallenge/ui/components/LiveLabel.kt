package com.example.nbcchallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LiveLabel(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        color = Color.White,
        modifier = modifier
            .padding(start = 8.dp, bottom = 8.dp)
            .background(color = Color.Red, shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}