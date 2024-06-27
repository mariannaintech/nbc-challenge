package com.example.nbcchallenge.data.datasource

import com.example.nbcchallenge.data.dto.HomePageDto

interface HomeDataSource {

    suspend fun loadHomePage(): HomePageDto
}
