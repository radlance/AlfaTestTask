package com.radlance.alfatesttask.domain.local

import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    fun loadHistory(): Flow<List<HistoryItem>>
    suspend fun saveHistoryItem(historyItem: HistoryItem)
}