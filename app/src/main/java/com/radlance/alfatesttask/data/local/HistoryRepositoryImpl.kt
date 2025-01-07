package com.radlance.alfatesttask.data.local

import com.radlance.alfatesttask.domain.local.HistoryItem
import com.radlance.alfatesttask.domain.local.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val dao: HistoryDao
) : HistoryRepository, LocalMapper() {
    override fun loadHistory(): Flow<List<HistoryItem>> {
        return dao.getHistory().map { history -> history.map { it.toHistoryItem() } }
    }

    override suspend fun saveHistoryItem(historyItem: HistoryItem) {
        val existQuery = dao.getHistoryItemByQuery(historyItem.bin)
        if (existQuery != null) {
            val updatedQuery = existQuery.copy(queryTime = historyItem.queryTime)
            dao.updateHistoryItem(updatedQuery)
        } else {
            dao.saveHistoryItem(historyItem.toHistoryItemEntity())
        }
    }
}