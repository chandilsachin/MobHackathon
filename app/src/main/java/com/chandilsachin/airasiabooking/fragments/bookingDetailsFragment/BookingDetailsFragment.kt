package com.chandilsachin.airasiabooking.fragments.bookingDetailsFragment


import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import com.chandilsachin.airasiabooking.R
import com.chandilsachin.airasiabooking.database.entities.BookingData
import com.chandilsachin.airasiabooking.fragments.bookingListFragment.BookingListViewModel
import com.chandilsachin.airasiabooking.util.lifecycle.arch.LifeCycleFragment
import com.chandilsachin.notely.util.initViewModel
import kotlinx.android.synthetic.main.fragment_booking_details.*
import kotlinx.android.synthetic.main.layout_filght_details.view.*
import kotlinx.android.synthetic.main.layout_passengers_details.view.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import java.util.*


class BookingDetailsFragment : LifeCycleFragment() {

    val mViewModel: BookingDetailsViewModel by lazy { initViewModel(BookingDetailsViewModel::class.java) }
    private var mPNR: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mPNR = arguments!!.getString(ARG_PNR)
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_booking_details

    override fun init(v: View?, savedInstanceState: Bundle?) {
        setUpToolbar(main_toolbar, R.string.bookingDetails)
    }

    override fun initLoadViews() {
        mViewModel.bookingDetailsLiveData.observe(this, Observer {
            it?.let {
                setupViewsData(it)
            }
        })

        mViewModel.getBookingDetails(mPNR)
    }

    @SuppressLint("SetTextI18n")
    private fun setupViewsData(data: BookingData) {
        val inflater = LayoutInflater.from(context)

        data.journeyServices?.segments?.let {
            if (BookingListViewModel.convertDate(it[0].departureTime).before(Date())) {
                tvStatus.text = "Completed"
                tvStatus.visibility = View.VISIBLE
            }
        }

        textViewPNR.text = "PNR no: ${data.pNR}"
        data.journeyServices?.segments?.let {
            if (it.size > 0) {
                tvDate.text = DateUtils.formatDateTime(context,
                        BookingListViewModel.convertDate(it[0].arrivalTime).time, DateUtils.FORMAT_SHOW_DATE)
                tvFromTo.text = "${it[0].departureStation} - ${it[it.size - 1].arrivalStation}"
                tvTime.text = "at " + DateUtils.formatDateTime(context,
                        BookingListViewModel.convertDate(it[0].departureTime).time, DateUtils.FORMAT_SHOW_TIME)
                tvDuration.text = " "
                tvNoOfStops.text = if (it.size == 1) "non-stop" else "${it.size} stops"

                for (segment in it) {
                    val view = inflater.inflate(R.layout.layout_filght_details, null, false)
                    view.tvFlightNo.text = segment.flightDesignator?.flightNumber
                    view.tvFlightDateTime.text = getPrettyDate(it[0].arrivalTime) + " at " + getPrettyTime(it[0].arrivalTime) + " to " +
                            getPrettyDate(it[0].departureTime) + " at " + getPrettyTime(it[0].departureTime)
                    view.tvFromToFlight.text = "${segment.departureStation} - ${segment.arrivalStation}"
                    linearFlightsContainer.addView(view)
                }
            }

            data.bookingPassengers?.adults?.let {
                for (adult in it) {
                    val view = inflater.inflate(R.layout.layout_passengers_details, null, false)
                    view.tvPassengarsName.text = "${adult?.firstName} ${adult?.middleName?:""} ${adult?.lastName?:""}"
                    view.tvAdultInfant.text = "(adult)"
                    linearPassengersContainer.addView(view)
                }
            }

            data.bookingPassengers?.infants?.let {
                for (adult in it) {
                    val view = inflater.inflate(R.layout.layout_passengers_details, null, false)
                    view.tvPassengarsName.text = "${adult?.firstName} ${adult?.middleName?:""} ${adult?.lastName?:""}"
                    view.tvAdultInfant.text = "(infant)"
                    linearPassengersContainer.addView(view)
                }
            }

        }


    }

    fun getPrettyDate(timestamp: String?): String {
        return DateUtils.formatDateTime(context,
                BookingListViewModel.convertDate(timestamp).time, DateUtils.FORMAT_SHOW_DATE)
    }

    fun getPrettyTime(timestamp: String?): String{
        return DateUtils.formatDateTime(context,
                BookingListViewModel.convertDate(timestamp).time, DateUtils.FORMAT_SHOW_TIME)
    }

    companion object {
        private val ARG_PNR = "PNR"
        const val TAG = "BookingDetailsFragment"

        fun newInstance(pnr: String?): BookingDetailsFragment {
            val fragment = BookingDetailsFragment()
            val args = Bundle()
            args.putString(ARG_PNR, pnr)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
