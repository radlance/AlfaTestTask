package com.radlance.alfatesttask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.radlance.alfatesttask.domain.LoadResult
import com.radlance.alfatesttask.domain.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardSearchViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val mapper: LoadResult.Mapper<LoadResultUiState>
) : ViewModel() {
    private val _searchResultUiState =
        MutableStateFlow<LoadResultUiState>(LoadResultUiState.Initial)
    val searchResultUiState: StateFlow<LoadResultUiState>
        get() = _searchResultUiState.asStateFlow()

    fun loadCardDetails(bin: String) {
        viewModelScope.launch {
            val result = remoteRepository.loadCardDetails(bin).map(mapper)
            _searchResultUiState.value = result
        }
    }
}