package com.example.nbcchallenge.data.di

import com.example.nbcchallenge.data.datasource.HomeDataSource
import com.example.nbcchallenge.data.HomeRepositoryImpl
import com.example.nbcchallenge.data.datasource.HomeDataSourceFile
import com.example.nbcchallenge.domain.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsDataSource(dataSource: HomeDataSourceFile) : HomeDataSource

    @Binds
    abstract fun bindsHomeRepository(repository: HomeRepositoryImpl): HomeRepository

}