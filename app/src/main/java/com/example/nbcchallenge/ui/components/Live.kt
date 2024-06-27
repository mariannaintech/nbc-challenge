package com.example.nbcchallenge.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nbcchallenge.domain.models.LiveItem

@Composable
fun LiveComponent(content: LiveItem) {
    Column(
        modifier = Modifier
            .width(224.dp)
            .height(200.dp)
    ) {
        Box {
            AsyncImage(
                model = content.image,
                modifier = Modifier
                    .height(128.dp)
                    .width(224.dp),
                contentDescription = "Content image",
                contentScale = ContentScale.Crop
            )
            Text(
                text = content.tagline,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp)
            )
            LiveLabel(modifier = Modifier.align(Alignment.BottomStart), text = content.type)
        }

        Spacer(modifier = Modifier.height(8.dp))
        ContentTitle(content.title)
        Spacer(modifier = Modifier.height(8.dp))
        ContentSubtitle(content.subtitle)
    }
}