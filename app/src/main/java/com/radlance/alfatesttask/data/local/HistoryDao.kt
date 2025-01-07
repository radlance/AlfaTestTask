package com.radlance.alfatesttask.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Query("SELECT * FROM history ORDER BY query_time")
    fun getHistory(): Flow<List<HistoryItemEntity>>

    @Query("SELECT * FROM history WHERE bin = :bin LIMIT 1")
    suspend fun getHistoryItemByQuery(bin: String): HistoryItemEntity?

    @Update
    suspend fun updateHistoryItem(historyItem: HistoryItemEntity)

    @Insert
    suspend fun saveHistoryItem(historyItem: HistoryItemEntity)
}