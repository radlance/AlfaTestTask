package com.radlance.alfatesttask.domain

interface RemoteRepository {
    suspend fun loadCardDetails(bin: String): LoadResult
}