package com.chandilsachin.airasiabooking.fragments.bookingDetailsFragment

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.chandilsachin.airasiabooking.database.entities.BookingData
import com.chandilsachin.airasiabooking.fragments.bookingListFragment.BookingListViewModel

/**
 * Created by sachin on 14/2/18.
 */
class BookingDetailsViewModel : ViewModel() {

    val bookingDetailsLiveData = MutableLiveData<BookingData>()

    fun getBookingDetails(pnr: String?) {
        val data = BookingListViewModel.bookingDataMap.get(pnr)
        bookingDetailsLiveData.value = data
    }
}