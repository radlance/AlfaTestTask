package com.radlance.alfatesttask.data

import com.radlance.alfatesttask.data.dto.CardDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteService {
    @GET("{bin}")
    suspend fun loadCardDetails(@Path("bin") bin: String): CardDetailsDto
}