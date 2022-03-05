package com.kt.keeptrackv1.ui.eventslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kt.keeptrack.data.db.EventsDatabase
import com.kt.keeptrackv1.R
import com.kt.keeptrackv1.data.repositories.EventsRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_layout)

        val database = EventsDatabase(this)
        val factory = AppViewModelFactory(repository = EventsRepository(database))
        val viewModel = ViewModelProvider(this, factory)[AppViewModel::class.java]
    }
}