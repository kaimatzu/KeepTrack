package com.kt.keeptrackv1.ui.eventslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kt.keeptrackv1.data.repositories.EventsRepository

class AppViewModelFactory(
    private val repository: EventsRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppViewModel(repository) as T
    }
}