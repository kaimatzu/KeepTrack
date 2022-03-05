package com.kt.keeptrack.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kt.keeptrackv1.data.db.EventsDao
import com.kt.keeptrackv1.data.db.entities.CalendarEvent

@Database(
    entities = [CalendarEvent::class],
    version = 1
)
abstract class EventsDatabase: RoomDatabase() {

    abstract fun getEventsDao(): EventsDao

    companion object {
        @Volatile
        private var instance: EventsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            EventsDatabase::class.java, "EventsDB.db").build()
    }
}