package com.kt.keeptrackv1.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_items")
data class CalendarEvent(
    @ColumnInfo(name = "status")
    var status : Boolean,
    @ColumnInfo(name = "event_name")
    val eventName : String,
    @ColumnInfo(name = "year")
    val year : Int,
    @ColumnInfo(name = "month")
    val month : Int,
    @ColumnInfo(name = "day")
    val day : Int,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}