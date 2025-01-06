package com.radlance.alfatesttask.presentation.history

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.radlance.alfatesttask.R
import com.radlance.alfatesttask.ui.theme.AlfaTestTaskTheme

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val history by viewModel.history.collectAsState()

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if(history.isEmpty()) {
            Text(text = stringResource(R.string.empty_search_history))
        } else {
            HistoryList(history = history, modifier = modifier)
        }
    }
}

@Preview
@Composable
private fun HistoryScreenPreview() {
    AlfaTestTaskTheme {
        HistoryScreen()
    }
}