package com.example.nbcchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContentTitle(title: String){
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            fontSize = 14.sp,
            maxLines = 2,
            lineHeight = 18.sp,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Logo(modifier = Modifier
            .size(16.dp)
            .align(Alignment.Top)
        )
    }
}