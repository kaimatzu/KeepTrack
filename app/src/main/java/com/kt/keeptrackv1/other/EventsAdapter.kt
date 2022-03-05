package com.kt.keeptrackv1.other

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kt.keeptrackv1.R
import com.kt.keeptrackv1.data.db.entities.CalendarEvent
import com.kt.keeptrackv1.ui.eventslist.AppViewModel
import kotlinx.android.synthetic.main.upcoming_events_item.view.*


class EventsAdapter(
    var item : List<CalendarEvent>,
    private val viewModel: AppViewModel
) : RecyclerView.Adapter<EventsAdapter.EventsViewHolder>(){

    inner class EventsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsAdapter.EventsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcoming_events_item, parent, false)
        return EventsViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
//        holder.itemView.apply {
//            eventButton.text = item[position].eventName

//        }

        val currEventsItem = item[position]

        holder.itemView.eventButton.text = currEventsItem.eventName

        holder.itemView.eventButton.setOnCheckedChangeListener{button, isChecked ->
            if(isChecked) {
                item[position].status = true
                holder.itemView.eventButton.setTextColor(Color.GRAY)
                Log.i("Button ", "Checked")
            }
            else {
                item[position].status = false
                holder.itemView.eventButton.setTextColor(Color.BLACK)
                Log.i("Button ", "Unchecked")
            }

        }

        holder.itemView.removeButton.setOnClickListener{
            viewModel.delete(currEventsItem)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}