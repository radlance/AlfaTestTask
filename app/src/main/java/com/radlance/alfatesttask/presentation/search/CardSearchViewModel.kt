package com.radlance.alfatesttask.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.radlance.alfatesttask.domain.local.HistoryItem
import com.radlance.alfatesttask.domain.local.HistoryRepository
import com.radlance.alfatesttask.domain.remote.LoadResult
import com.radlance.alfatesttask.domain.remote.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class CardSearchViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val historyRepository: HistoryRepository,
    private val mapper: LoadResult.Mapper<LoadResultUiState>
) : ViewModel() {
    private val _searchResultUiState =
        MutableStateFlow<LoadResultUiState>(LoadResultUiState.Initial)
    val searchResultUiState: StateFlow<LoadResultUiState>
        get() = _searchResultUiState.asStateFlow()

    fun loadCardDetails(bin: String) {
        viewModelScope.launch {
            _searchResultUiState.value = LoadResultUiState.Loading
            val result = remoteRepository.loadCardDetails(bin)
            _searchResultUiState.value = result.map(mapper)
            if (result is LoadResult.Success) {
                val historyItem = HistoryItem(
                    bin = bin.trim(),
                    bankName = result.cardDetails.bankName ?: "",
                    queryTime = LocalDateTime.now()
                )

                historyRepository.saveHistoryItem(historyItem)
            }
        }
    }
}