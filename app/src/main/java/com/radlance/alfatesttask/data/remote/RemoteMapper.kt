package com.radlance.alfatesttask.data.remote

import com.radlance.alfatesttask.data.remote.dto.CardDetailsDto
import com.radlance.alfatesttask.domain.remote.CardDetails

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