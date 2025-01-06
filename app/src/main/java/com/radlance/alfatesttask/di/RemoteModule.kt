package com.radlance.alfatesttask.di

import com.radlance.alfatesttask.data.RemoteRepositoryImpl
import com.radlance.alfatesttask.domain.LoadResult
import com.radlance.alfatesttask.domain.RemoteRepository
import com.radlance.alfatesttask.presentation.LoadResultMapper
import com.radlance.alfatesttask.presentation.LoadResultUiState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteModule {
    @Binds
    fun provideRemoteRepository(remoteRepository: RemoteRepositoryImpl): RemoteRepository

    @Binds
    fun provideMapper(mapper: LoadResultMapper): LoadResult.Mapper<LoadResultUiState>
}