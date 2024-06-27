package com.example.nbcchallenge.data

import com.example.nbcchallenge.data.datasource.HomeDataSource
import com.example.nbcchallenge.data.mapper.toDomain
import com.example.nbcchallenge.domain.HomeRepository
import com.example.nbcchallenge.domain.models.HomePageInfo
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: HomeDataSource
) : HomeRepository {

    override suspend fun loadHomePage(): HomePageInfo {
        return dataSource.loadHomePage().toDomain()
    }

}