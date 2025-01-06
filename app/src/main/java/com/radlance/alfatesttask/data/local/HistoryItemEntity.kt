package com.radlance.alfatesttask.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryItemEntity(
    val bin: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
