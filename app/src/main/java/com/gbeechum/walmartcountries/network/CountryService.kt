package com.gbeechum.walmartcountries.network

import com.gbeechum.walmartcountries.model.CountryResponse
import com.gbeechum.walmartcountries.utils.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface CountryService {
    @GET(ENDPOINT)
    suspend fun getCountries(): Response<List<CountryResponse>>
}