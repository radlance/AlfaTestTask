package com.radlance.alfatesttask.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "history")
data class HistoryItemEntity(
    val bin: String,
    @ColumnInfo(name = "bank_name") val bankName: String,
    @ColumnInfo(name = "query_time") val queryTime: LocalDateTime,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
