package com.radlance.alfatesttask.presentation.history

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.radlance.alfatesttask.domain.local.HistoryItem
import com.radlance.alfatesttask.ui.theme.AlfaTestTaskTheme

@Composable
fun HistoryCard(
    historyItem: HistoryItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
        .fillMaxWidth()
        .height(60.dp)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = historyItem.bin, fontSize = 24.sp)
        }
    }
}

@Preview
@Composable
private fun HistoryCardPreview() {
    AlfaTestTaskTheme {
        HistoryCard(historyItem = HistoryItem(id = 1, bin = "123456"))
    }
}