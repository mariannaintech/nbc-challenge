package com.example.nbcchallenge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nbcchallenge.domain.models.EpisodeItem
import com.example.nbcchallenge.domain.models.LiveItem
import com.example.nbcchallenge.domain.models.ShowItem
import com.example.nbcchallenge.ui.components.Episode
import com.example.nbcchallenge.ui.components.LiveComponent
import com.example.nbcchallenge.ui.components.ShelfTitle
import com.example.nbcchallenge.ui.components.Show
import com.example.nbcchallenge.ui.theme.gradient
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen(viewModel)
        }
    }
}

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val homeData by viewModel.state.collectAsState()
    val finalHomeData = homeData
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            if (finalHomeData is HomeViewState.Success) {
                val shelves = finalHomeData.data.shelves
                itemsIndexed(shelves) { row, shelf ->
                    if (row == 0) {
                        Spacer(modifier = Modifier.height(56.dp))
                    }
                    ShelfTitle(shelf.title)
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        val contentList = shelf.items
                        itemsIndexed(contentList) { column, content ->
                            if (column == 0) {
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                            when (content) {
                                is ShowItem -> Show(content)
                                is EpisodeItem -> Episode(content)
                                is LiveItem -> LiveComponent(content)
                            }
                            if (column == contentList.lastIndex) {
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                        }
                    }
                    if (row == shelves.lastIndex) {
                        Spacer(modifier = Modifier.height(56.dp))
                    }
                }
            }
        }
    }
}