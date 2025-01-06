package com.radlance.alfatesttask.domain.remote

interface RemoteRepository {
    suspend fun loadCardDetails(bin: String): LoadResult
}