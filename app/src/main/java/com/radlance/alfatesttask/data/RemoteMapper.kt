package com.radlance.alfatesttask.data

import com.radlance.alfatesttask.data.dto.CardDetailsDto
import com.radlance.alfatesttask.domain.CardDetails

abstract class RemoteMapper {
    protected fun CardDetailsDto.toCardDetails(): CardDetails {
        return CardDetails(
            scheme = scheme,
            type = type,
            brand = brand,
            countryName = country.name,
            bankName = bank.name,
            bankUrl = bank.url,
            bankPhone = bank.phone,
            bankCity = bank.city
        )
    }
}