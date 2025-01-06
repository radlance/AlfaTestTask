package com.radlance.alfatesttask.di

import com.radlance.alfatesttask.data.remote.RemoteRepositoryImpl
import com.radlance.alfatesttask.domain.remote.LoadResult
import com.radlance.alfatesttask.domain.remote.RemoteRepository
import com.radlance.alfatesttask.presentation.search.LoadResultMapper
import com.radlance.alfatesttask.presentation.search.LoadResultUiState
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