package com.example.nbcchallenge.data.datasource

import android.content.Context
import com.example.nbcchallenge.data.dto.HomePageDto
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HomeDataSourceFile @Inject constructor(
    @ApplicationContext private val context: Context
) : HomeDataSource {

    companion object {
        private const val HOME_PAGE_FILE = "homepage.json"
        private const val HOME_PAGE_MORE_SHELVES_FILE = "homepage_more_shelves.json"
    }

    private val gson = Gson()

    override suspend fun loadHomePage(): HomePageDto {
        return context.assets.open(HOME_PAGE_FILE).bufferedReader().use {
            gson.fromJson(it, HomePageDto::class.java)
        }
    }
}
