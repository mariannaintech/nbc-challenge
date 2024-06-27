package com.example.nbcchallenge.data

import com.example.nbcchallenge.data.datasource.HomeDataSource
import com.example.nbcchallenge.data.dto.ContentDto
import com.example.nbcchallenge.data.dto.HomePageDto
import com.example.nbcchallenge.data.dto.ShelfDto
import com.example.nbcchallenge.data.mapper.toDomain
import com.example.nbcchallenge.domain.HomeRepository
import com.example.nbcchallenge.domain.models.HomePageInfo
import com.example.nbcchallenge.domain.models.ShelfInfo
import com.example.nbcchallenge.domain.models.ShowItem
import com.example.nbcchallenge.ui.HomeViewState
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class TestHomeRepository {

    private lateinit var homeDataSource: HomeDataSource
    private lateinit var homeRepository: HomeRepository

    @Before
    fun setUp() {
        homeDataSource = mock()
        homeRepository = HomeRepositoryImpl(homeDataSource)
    }

    @Test
    fun `loadHomePage should emit HomePageInfo`() = runTest {
        val items = listOf(
            ContentDto("Show", "", "Title 1", "", "", ""),
            ContentDto("Show", "", "Title 2", "", "", "")
        )
        val shelves = listOf(ShelfDto("Title", "Type", items))
        val expected = HomePageDto("HOMEPAGE", shelves)
        whenever(homeDataSource.loadHomePage()).thenReturn(expected)

        val actual = homeRepository.loadHomePage()
        assertEquals(expected.toDomain(), actual)
    }

}