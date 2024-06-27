package com.example.nbcchallenge.domain

import com.example.nbcchallenge.domain.models.HomePageInfo
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    private val repository: HomeRepository
) : HomeUseCase {

    override suspend fun loadData(): Result<HomePageInfo> {
        return try {
            val response = repository.loadHomePage()
            Result.success(response)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}