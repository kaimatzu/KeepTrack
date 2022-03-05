package com.kt.keeptrackv1.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kt.keeptrackv1.data.db.entities.CalendarEvent

@Dao
interface EventsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: CalendarEvent)

    @Delete
    suspend fun delete(item: CalendarEvent)

    @Query("SELECT * FROM event_items")
    fun getAllItems(): LiveData<List<CalendarEvent>>
}