package com.radlance.alfatesttask.data.local

import com.radlance.alfatesttask.domain.local.HistoryItem

abstract class LocalMapper {
    fun HistoryItemEntity.toHistoryItem(): HistoryItem {
        return HistoryItem(bin = bin, id = id)
    }

    fun HistoryItem.toHistoryItemEntity(): HistoryItemEntity {
        return HistoryItemEntity(bin = bin, id = id)
    }
}