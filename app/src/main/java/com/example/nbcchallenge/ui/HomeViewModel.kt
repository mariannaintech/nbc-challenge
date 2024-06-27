package com.example.nbcchallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nbcchallenge.domain.HomeUseCase
import com.example.nbcchallenge.domain.models.HomePageInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import io.getstream.log.taggedLogger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {

    private val logger by taggedLogger("HomeViewModel")

    private val _state = MutableStateFlow<HomeViewState?>(null)
    val state: StateFlow<HomeViewState?> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            homeUseCase.loadData()
                .onSuccess {
                    logger.v { "[loadData] completed: $it" }
                    _state.value = HomeViewState.Success(it)
                }.onFailure {
                    logger.e { "[loadData] failed: $it" }
                    _state.value = HomeViewState.Failure(it)
                }
        }
    }
}

sealed class HomeViewState {
    data class Success(val data: HomePageInfo) : HomeViewState()
    data class Failure(val cause: Throwable) : HomeViewState()
}