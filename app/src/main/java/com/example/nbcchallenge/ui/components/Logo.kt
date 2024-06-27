package com.example.nbcchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.nbcchallenge.R

@Composable
fun Logo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.nbc_logo),
        contentDescription = "NBC Logo",
        modifier = modifier,
        contentScale = ContentScale.Fit
    )
}