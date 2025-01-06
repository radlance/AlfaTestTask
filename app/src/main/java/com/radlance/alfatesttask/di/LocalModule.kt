package com.radlance.alfatesttask.di

import com.radlance.alfatesttask.data.local.HistoryRepositoryImpl
import com.radlance.alfatesttask.domain.local.HistoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LocalModule {
    @Binds
    fun provideHistoryRepository(historyRepository: HistoryRepositoryImpl): HistoryRepository
}