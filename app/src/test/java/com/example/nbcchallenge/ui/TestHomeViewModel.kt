package com.example.nbcchallenge.ui

import com.example.nbcchallenge.domain.HomeUseCase
import com.example.nbcchallenge.domain.models.HomePageInfo
import com.example.nbcchallenge.domain.models.ShelfInfo
import com.example.nbcchallenge.domain.models.ShowItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    private val homeUseCase: HomeUseCase = mock()
    private val testDispatcher = StandardTestDispatcher()


    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadData should emit Success state when use case returns data`() = runTest {
        val items = listOf(
            ShowItem("Show", "Title 1", ""),
            ShowItem("Show", "Title 2", "")
        )
        val shelves = listOf(ShelfInfo("Title", "Type", items))
        val expected = HomePageInfo("HOMEPAGE", shelves)
        whenever(homeUseCase.loadData()).thenReturn(Result.success(expected))

        val vm = HomeViewModel(homeUseCase)

        val actual = vm.state.filterNotNull().first()
        assertEquals(HomeViewState.Success(expected), actual)
    }

    @Test
    fun `loadData should emit Failure state when use case returns error`() = runTest {
        val exception = RuntimeException("Something went wrong")
        whenever(homeUseCase.loadData()).thenReturn(Result.failure(exception))

        val vm = HomeViewModel(homeUseCase)

        val actual = vm.state.filterNotNull().first()
        assertEquals(HomeViewState.Failure(exception), actual)
    }
}
