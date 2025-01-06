package com.radlance.alfatesttask.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Query("SELECT * FROM history")
    fun getHistory(): Flow<List<HistoryItemEntity>>

    @Insert
    suspend fun saveHistoryItem(historyItem: HistoryItemEntity)
}