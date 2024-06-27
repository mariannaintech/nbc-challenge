package com.example.nbcchallenge.domain

import com.example.nbcchallenge.domain.models.HomePageInfo

interface HomeUseCase {

    suspend fun loadData() : Result<HomePageInfo>
}