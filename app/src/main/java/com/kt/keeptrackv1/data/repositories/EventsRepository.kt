package com.kt.keeptrackv1.data.repositories

import com.kt.keeptrack.data.db.EventsDatabase
import com.kt.keeptrackv1.data.db.entities.CalendarEvent

class EventsRepository(
    private val db: EventsDatabase
) {
    suspend fun upsert(item : CalendarEvent) = db.getEventsDao().upsert(item)

    suspend fun delete(item: CalendarEvent) = db.getEventsDao().delete(item)

    fun getAllItems() = db.getEventsDao().getAllItems()
}