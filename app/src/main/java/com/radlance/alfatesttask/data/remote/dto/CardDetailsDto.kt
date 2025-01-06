package com.radlance.alfatesttask.data.remote.dto

data class CardDetailsDto(
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val country: CountryDto,
    val bank: BankDetailsDto
)
