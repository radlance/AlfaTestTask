package com.radlance.alfatesttask.presentation

import com.radlance.alfatesttask.domain.CardDetails
import com.radlance.alfatesttask.domain.LoadResult
import javax.inject.Inject

class LoadResultMapper @Inject constructor() : LoadResult.Mapper<LoadResultUiState> {
    override fun mapSuccess(cardDetails: CardDetails): LoadResultUiState {
        return LoadResultUiState.Success(cardDetails)
    }

    override fun mapError(noConnection: Boolean): LoadResultUiState {
        return LoadResultUiState.Error(noConnection)
    }
}