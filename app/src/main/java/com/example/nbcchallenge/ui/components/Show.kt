package com.example.nbcchallenge.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nbcchallenge.domain.models.ShowItem

@Composable
fun Show(content: ShowItem) {
    Column(
        modifier = Modifier
            .height(248.dp)
            .width(152.dp)
    ) {
        AsyncImage(
            model = content.image,
            modifier = Modifier
                .height(200.dp)
                .width(152.dp),
            contentDescription = "Content image",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        ContentTitle(content.title)
    }
}