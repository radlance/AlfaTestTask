package com.radlance.alfatesttask.presentation.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.radlance.alfatesttask.domain.local.HistoryItem
import com.radlance.alfatesttask.ui.theme.AlfaTestTaskTheme
import java.time.LocalDateTime

@Composable
fun HistoryList(
    history: List<HistoryItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(12.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(items = history, key = { historyItem -> historyItem.id }) { historyItem ->
            HistoryCard(historyItem = historyItem)
        }
    }
}

@Preview
@Composable
private fun HistoryListPreview() {
    AlfaTestTaskTheme {
        HistoryList(
            history = List(20) {
                HistoryItem(
                    id = it,
                    bin = "${123456 + it}",
                    bankName = "$it",
                    queryTime = LocalDateTime.now()
                )
            }
        )
    }
}