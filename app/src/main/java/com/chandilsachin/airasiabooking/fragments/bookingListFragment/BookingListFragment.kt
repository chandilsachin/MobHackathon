package com.chandilsachin.airasiabooking.fragments.bookingListFragment


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chandilsachin.airasiabooking.R
import com.chandilsachin.airasiabooking.util.lifecycle.arch.LifeCycleFragment
import com.chandilsachin.notely.util.initViewModel
import kotlinx.android.synthetic.main.fragment_booking_list.*


class BookingListFragment : LifeCycleFragment() {

    val mViewModel: BookingListViewModel by lazy { initViewModel(BookingListViewModel::class.java) }
    private var mMode: Int? = null
    private lateinit var listAdapter: BookingListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mMode = arguments!!.getInt(ARG_MODE)
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_booking_list

    override fun init(v: View?, savedInstanceState: Bundle?) {
        recyclerViewBookingList.layoutManager = LinearLayoutManager(context)
        listAdapter = BookingListAdapter(context, emptyList())
        recyclerViewBookingList.adapter = listAdapter
    }

    override fun initLoadViews() {

        if(mMode == MODE_UPCOMING) {
            mViewModel.upComingListLiveData.observe(this, Observer {
                it?.let {
                    listAdapter.listItems = it
                    listAdapter.notifyDataSetChanged()
                }
            })
        }else{
            mViewModel.completedListLiveData.observe(this, Observer {
                it?.let {
                    listAdapter.listItems = it
                    listAdapter.notifyDataSetChanged()
                }
            })
        }

        mViewModel.loadBookingList(context)
    }

    companion object {
        private val ARG_MODE = "MODE"

        const val MODE_UPCOMING = 1
        const val MODE_COMPLETED = 2

        fun newInstance(mode: Int): BookingListFragment {
            val fragment = BookingListFragment()
            val args = Bundle()
            args.putInt(ARG_MODE, mode)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
