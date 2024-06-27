package com.example.nbcchallenge.domain

import com.example.nbcchallenge.domain.models.HomePageInfo

interface HomeRepository {

    suspend fun loadHomePage(): HomePageInfo

}