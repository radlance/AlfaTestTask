package com.radlance.alfatesttask.data

import com.radlance.alfatesttask.domain.LoadResult
import com.radlance.alfatesttask.domain.RemoteRepository
import java.net.UnknownHostException
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val service: RemoteService
) : RemoteRepository, RemoteMapper() {
    override suspend fun loadCardDetails(bin: String): LoadResult {
        return try {
            val cardDetails = service.loadCardDetails(bin).toCardDetails()
            LoadResult.Success(cardDetails)
        } catch (e: Exception) {
            LoadResult.Error(e is UnknownHostException)
        }
    }
}