package com.example.dicodingaplikasi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dicodingaplikasi.data.local.entity.EventEntity
import com.example.dicodingaplikasi.data.local.repository.EventRepository
import kotlinx.coroutines.launch

class EventViewModel(private val eventRepository: EventRepository) : ViewModel() {
    fun getHeadEvent() = eventRepository.getHeadEvent()

    fun getFavorite() = eventRepository.getFavorite()

    fun setFavorite(event: EventEntity) {
        viewModelScope.launch {
            eventRepository.setFavorite(event, true)
        }
    }

    fun deleteFavorite(event: EventEntity) {
        viewModelScope.launch {
            eventRepository.setFavorite(event, false)
        }

    }


}