package com.chandilsachin.airasiabooking.fragments.bookingFragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.chandilsachin.airasiabooking.fragments.bookingListFragment.BookingListFragment

/**
 * Created by sachin on 13/2/18.
 */
class BookingFragmentPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    val PAGES = 2

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                return BookingListFragment.newInstance(BookingListFragment.MODE_UPCOMING)
            }
            1 -> {
                return BookingListFragment.newInstance(BookingListFragment.MODE_COMPLETED)
            }
        }
        return BookingListFragment.newInstance(BookingListFragment.MODE_UPCOMING)
    }

    override fun getCount(): Int = PAGES
}