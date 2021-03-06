package com.gbeechum.walmartcountries.model

sealed class UIState {
    object Loading : UIState()
    data class Error(val msg: String) : UIState()
    data class Success(val countryResponses: List<CountryResponse>) : UIState()
}