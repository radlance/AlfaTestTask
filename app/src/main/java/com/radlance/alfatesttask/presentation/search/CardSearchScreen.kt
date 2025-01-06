package com.radlance.alfatesttask.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.radlance.alfatesttask.R
import com.radlance.alfatesttask.ui.theme.AlfaTestTaskTheme

@Composable
fun CardSearch(
    modifier: Modifier = Modifier,
    viewModel: CardSearchViewModel = hiltViewModel()
) {
    val softwareKeyboardController = LocalSoftwareKeyboardController.current

    var searchFieldValue by rememberSaveable { mutableStateOf("") }
    val searchResultUiState by viewModel.searchResultUiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .safeDrawingPadding()
    ) {
        OutlinedTextField(
            value = searchFieldValue,
            onValueChange = { searchFieldValue = it },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.bin)) }
        )

        Spacer(modifier = modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.loadCardDetails(searchFieldValue)
                softwareKeyboardController?.hide()
            },
            enabled = searchFieldValue.length >= 6,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.search))
        }
        Spacer(Modifier.height(32.dp))
        searchResultUiState.Show()
    }
}

@Preview(showBackground = true)
@Composable
private fun CardSearchPreview() {
    AlfaTestTaskTheme {
        CardSearch()
    }
}