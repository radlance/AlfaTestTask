package com.radlance.alfatesttask.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.radlance.alfatesttask.R
import com.radlance.alfatesttask.domain.remote.CardDetails
import com.radlance.alfatesttask.ui.theme.AlfaTestTaskTheme
import sh.calvin.autolinktext.rememberAutoLinkText

@Composable
fun SuccessSearchScreen(
    cardDetails: CardDetails,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        val detailsList = listOf(
            cardDetails.scheme,
            cardDetails.type,
            cardDetails.brand,
            cardDetails.countryName,
            cardDetails.bankName,
            cardDetails.bankUrl,
            cardDetails.bankPhone,
            cardDetails.bankCity
        )

        if (detailsList.all { it == null }) {
            Text(
                text = stringResource(R.string.no_information),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            with(cardDetails) {
                scheme?.let { Text(text = "Схема: $it") }
                type?.let { Text(text = "Тип: $it") }
                brand?.let { Text(text = "Бренд: $it") }
                countryName?.let { Text(text = "Страна: $it") }
                bankName?.let { Text(text = "Банк: $it") }
                bankUrl?.let {
                    Text(
                        text = AnnotatedString.rememberAutoLinkText(
                            "Страница банка: $it"
                        ),
                    )
                }
                bankPhone?.let {
                    Text(
                        text = AnnotatedString.rememberAutoLinkText(
                            "Телефон банка: $it"
                        )
                    )
                }
                bankCity?.let { Text(text = "Город банка: $it") }
            }
        }
    }
}

@Preview
@Composable
private fun SuccessSearchScreenPreview() {
    AlfaTestTaskTheme {
        SuccessSearchScreen(
            CardDetails(
                scheme = "visa",
                type = "debit",
                brand = "Visa/Dankort",
                countryName = "Denmark",
                bankName = "Jyske Bank",
                bankUrl = "www.jyskebank.dk",
                bankPhone = "+4589893300",
                bankCity = "Hjørring"
            )
        )
    }
}