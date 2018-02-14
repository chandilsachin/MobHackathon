package com.chandilsachin.airasiabooking.fragments.bookingListFragment

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.chandilsachin.airasiabooking.database.entities.BookingData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.Reader
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by sachin on 13/2/18.
 */
class BookingListViewModel : ViewModel() {

    val upComingListLiveData = MutableLiveData<List<BookingData>>()
    val completedListLiveData = MutableLiveData<List<BookingData>>()

    fun loadBookingList(context: Context?) {

        Single.create<List<BookingData>> {
            val input = context?.assets?.open("a_booking_input.json")
            val reader = input?.bufferedReader()
            val gson = Gson()
            val token = object : TypeToken<ArrayList<BookingData>>() {}
            val data = gson.fromJson<List<BookingData>>(reader, token.type)
            it.onSuccess(data)
        }.flatMapObservable { Observable.fromIterable(it) }
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .toList()
                .subscribe({
                    filterList(it)
                }, { it.printStackTrace() })
    }

    private fun filterList(list: List<BookingData>){
        val upComingList = mutableListOf<BookingData>()
        val completedList = mutableListOf<BookingData>()
        for (item in list){
            item.journeyServices?.segments?.let {
                if(convertDate(it[0].departureTime).after(Date()))
                    upComingList.add(item)
                else{
                    completedList.add(item)
                }
                if(item.pNR != null)
                    bookingDataMap.put(item.pNR, item)
            }
        }
        upComingListLiveData.value = upComingList
        completedListLiveData.value = completedList
    }

    companion object {
        val bookingDataMap = hashMapOf<String, BookingData>()
        @SuppressLint("SimpleDateFormat")
        fun convertDate(timestamp: String?): Date {
            return SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(timestamp?.replace("T", " "))
        }
    }


}