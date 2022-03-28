package com.gbeechum.walmartcountries.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gbeechum.walmartcountries.model.UIState
import com.gbeechum.walmartcountries.network.CountryRepositoryImpl
import kotlinx.coroutines.launch

class CountryViewModel(private val repository: CountryRepositoryImpl) : ViewModel() {

    private val _countryLiveData = MutableLiveData<UIState>()
    val countryLiveData: LiveData<UIState>
        get() = _countryLiveData

    init {
        getCountries()
    }

    private fun getCountries() {
        _countryLiveData.value = UIState.Loading
        viewModelScope.launch {
            val response = repository.getCountries()

            if (response.isSuccessful) {
                _countryLiveData.postValue(UIState.Success(response.body()!!))
            } else {
                _countryLiveData.postValue(UIState.Error("Failed network call"))
            }
        }
    }
}

