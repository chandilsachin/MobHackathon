package com.chandilsachin.airasiabooking.fragments.bookingListFragment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chandilsachin.airasiabooking.R
import com.chandilsachin.airasiabooking.database.entities.BookingData
import kotlinx.android.synthetic.main.list_item_booking_list.view.*

/**
 * Created by sachin on 13/2/18.
 */
class BookingListAdapter (val context: Context?, var listItems: List<BookingData>): RecyclerView.Adapter<BookingListAdapter.ViewHolder>(){

    val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(context, layoutInflater.inflate(R.layout.list_item_booking_list, parent, false))
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(listItems[position])
    }


    class ViewHolder(val context: Context?, itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(bookingData: BookingData){
            bookingData.journeyServices?.segments?.let {
                itemView.tvDate.text = DateUtils.formatDateTime(context,
                        BookingListViewModel.convertDate(it[0].arrivalTime).time, DateUtils.FORMAT_SHOW_DATE)
                itemView.tvFromTo.text = "${it[0].departureStation} - ${it[0].arrivalStation}"
                itemView.tvTime.text = DateUtils.formatDateTime(context,
                        BookingListViewModel.convertDate(it[0].departureTime).time, DateUtils.FORMAT_SHOW_TIME)
                itemView.tvDuration.text = " "
                itemView.tvNoOfStops.text = if(it.size == 1) "non-stop" else "${it.size} stops"
            }
            bookingData.bookingContacts?.let {
                if(it.isNotEmpty())
                    itemView.tvName.text = "${it[0]?.name?.firstName} ${it[0]?.name?.lastName}"
            }

        }
    }
}