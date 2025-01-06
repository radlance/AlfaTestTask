package com.radlance.alfatesttask.presentation.search

import com.radlance.alfatesttask.domain.remote.CardDetails
import com.radlance.alfatesttask.domain.remote.LoadResult
import javax.inject.Inject

class LoadResultMapper @Inject constructor() : LoadResult.Mapper<LoadResultUiState> {
    override fun mapSuccess(cardDetails: CardDetails): LoadResultUiState {
        return LoadResultUiState.Success(cardDetails)
    }

    override fun mapError(noConnection: Boolean): LoadResultUiState {
        return LoadResultUiState.Error(noConnection)
    }
}