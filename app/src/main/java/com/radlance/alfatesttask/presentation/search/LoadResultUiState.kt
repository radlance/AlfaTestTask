package com.radlance.alfatesttask.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.radlance.alfatesttask.domain.remote.CardDetails

interface LoadResultUiState {
    @Composable
    fun Show()

    data class Success(private val cardDetails: CardDetails) : LoadResultUiState {
        @Composable
        override fun Show() {
            SuccessSearchScreen(cardDetails = cardDetails)
        }
    }

    data class Error(private val noConnection: Boolean) : LoadResultUiState {
        @Composable
        override fun Show() {
            ErrorSearchResult(noConnection = noConnection)
        }
    }

    object Initial : LoadResultUiState {
        @Composable
        override fun Show() {}
    }

    object Loading : LoadResultUiState {
        @Composable
        override fun Show() {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }
    }
}