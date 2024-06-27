package com.example.nbcchallenge.domain.di

import com.example.nbcchallenge.domain.HomeUseCase
import com.example.nbcchallenge.domain.HomeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsHomeUseCase(useCase: HomeUseCaseImpl) : HomeUseCase

}