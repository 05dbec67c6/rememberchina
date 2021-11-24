package com.rememberchina.fragment_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rememberchina.network.ChinaEvent
import com.rememberchina.network.ChinaEventApi
import kotlinx.coroutines.launch

enum class ChinaEventApiStatus { LOADING, ERROR, DONE }

class ListViewModel : ViewModel() {

    // List of ChinaEvents
    private val _chinaEvents = MutableLiveData<List<ChinaEvent>>()
    val chinaEvents: LiveData<List<ChinaEvent>>
        get() = _chinaEvents


    // Loading Status
    private val _status = MutableLiveData<ChinaEventApiStatus>()
    val status: LiveData<ChinaEventApiStatus>
        get() = _status

    init {
        getChinaEvents()
    }

    private fun getChinaEvents() {
        viewModelScope.launch {

            _status.value = ChinaEventApiStatus.LOADING

            try {
                _chinaEvents.value = ChinaEventApi.retrofitService.getChinaEvents()
                _status.value = ChinaEventApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ChinaEventApiStatus.ERROR
                _chinaEvents.value = ArrayList()
            }
        }
    }
}