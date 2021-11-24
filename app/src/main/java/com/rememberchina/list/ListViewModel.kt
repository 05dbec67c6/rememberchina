package com.rememberchina.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rememberchina.network.ChinaEvent
import com.rememberchina.network.ChinaEventApi
import kotlinx.coroutines.launch



class ListViewModel : ViewModel() {

    // List of ChinaEvents
    private val _chinaEvents = MutableLiveData<List<ChinaEvent>>()
    val chinaEvents: LiveData<List<ChinaEvent>>
        get() = _chinaEvents

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getChinaEvents()
    }

    private fun getChinaEvents() {
        viewModelScope.launch {
            try {
                _chinaEvents.value = ChinaEventApi.retrofitService.getChinaEvents()
                _response.value = "Success: China events retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}