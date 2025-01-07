package com.radlance.alfatesttask.domain.local

import java.time.LocalDateTime

data class HistoryItem(
    val bin: String,
    val bankName: String,
    val queryTime: LocalDateTime,
    val id: Int = 0
)
