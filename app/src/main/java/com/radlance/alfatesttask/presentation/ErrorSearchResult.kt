package com.radlance.alfatesttask.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.radlance.alfatesttask.R
import com.radlance.alfatesttask.ui.theme.AlfaTestTaskTheme

@Composable
fun ErrorSearchResult(
    noConnection: Boolean,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        val errorMessage = if (noConnection) {
            R.string.no_connection
        } else {
            R.string.load_error
        }
        Text(
            text = stringResource(errorMessage),
            color = Color.Red
        )
    }
}

@Preview
@Composable
private fun ErrorSearchResultPreview() {
    AlfaTestTaskTheme {
        ErrorSearchResult(true)
    }
}