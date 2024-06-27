package com.example.nbcchallenge.domain

import com.example.nbcchallenge.domain.models.HomePageInfo
import com.example.nbcchallenge.domain.models.ShelfInfo
import com.example.nbcchallenge.domain.models.ShowItem
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class TestHomeUseCase {

    private lateinit var homeRepository: HomeRepository
    private lateinit var homeUseCase: HomeUseCase

    @Before
    fun setUp() {
        homeRepository = mock()
        homeUseCase = HomeUseCaseImpl(homeRepository)
    }

    @Test
    fun `loadData should emit success result when repository returns data`() = runTest {
        val items = listOf(
            ShowItem("Show", "Title 1", ""),
            ShowItem("Show", "Title 2", "")
        )
        val shelves = listOf(ShelfInfo("Title", "Type", items))
        val expected = HomePageInfo("HOMEPAGE", shelves)
        whenever(homeRepository.loadHomePage()).thenReturn(expected)

        val actual = homeUseCase.loadData()
        assertEquals(Result.success(expected), actual)
    }

    @Test
    fun `loadData should emit failure result when repository returns error`() = runTest {
        val expected = RuntimeException("test exception")
        whenever(homeRepository.loadHomePage()).thenThrow(expected)

        val actual = homeUseCase.loadData()
        assertEquals(Result.failure<HomePageInfo>(expected), actual)
    }

}