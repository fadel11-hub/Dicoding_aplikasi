package com.example.dicodingaplikasi.ui.upcoming

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dicodingaplikasi.data.response.ListEventsItem
import com.example.dicodingaplikasi.data.response.Response
import com.example.dicodingaplikasi.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback

class UpcomingViewModel: ViewModel() {

    private val _listEvent = MutableLiveData<List<ListEventsItem>>()
    val listEvent: LiveData<List<ListEventsItem>> = _listEvent

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading



    companion object{
        private const val TAG = "UpcomingViewModel"
        private const val EVENT_ID = 1
    }

    init {
        listUpcomingEvent()
    }

    private fun listUpcomingEvent() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getUpComing(EVENT_ID)
        client.enqueue(object : Callback<Response> {
            override fun onResponse(
                call: Call<Response>,
                response: Response<Response>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _listEvent.value = response.body()?.listEvents
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
}