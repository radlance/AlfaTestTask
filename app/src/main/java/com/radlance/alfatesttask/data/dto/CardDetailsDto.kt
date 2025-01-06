package com.radlance.alfatesttask.data.dto

data class CardDetailsDto(
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val country: CountryDto,
    val bank: BankDetailsDto
)
