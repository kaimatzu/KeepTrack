package com.kt.keeptrackv1.ui.eventslist

import androidx.lifecycle.ViewModel
import com.kt.keeptrackv1.data.db.entities.CalendarEvent
import com.kt.keeptrackv1.data.repositories.EventsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel(
    private val repository: EventsRepository
): ViewModel() {

    fun upsert(item: CalendarEvent) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: CalendarEvent) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllItems() = repository.getAllItems()
}