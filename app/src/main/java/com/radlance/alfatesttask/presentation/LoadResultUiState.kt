package com.radlance.alfatesttask.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.radlance.alfatesttask.domain.CardDetails

interface LoadResultUiState {
    @Composable
    fun Show()

    data class Success(private val cardDetails: CardDetails) : LoadResultUiState {
        @Composable
        override fun Show() {
            Text(text = cardDetails.toString())
        }
    }

    data class Error(private val noConnection: Boolean) : LoadResultUiState {
        @Composable
        override fun Show() {
            Text(text = if (noConnection) "no connection" else "unknown error")
        }
    }

    object Initial : LoadResultUiState {
        @Composable
        override fun Show() {}
    }
}