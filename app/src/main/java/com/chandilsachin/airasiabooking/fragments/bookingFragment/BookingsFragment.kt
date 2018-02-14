package com.chandilsachin.airasiabooking.fragments.bookingFragment


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import com.chandilsachin.airasiabooking.R
import com.chandilsachin.airasiabooking.util.lifecycle.arch.LifeCycleFragment
import com.chandilsachin.notely.util.getAppCompactActivity
import kotlinx.android.synthetic.main.fragment_bookings.*
import kotlinx.android.synthetic.main.toolbar_layout.*


class BookingsFragment : LifeCycleFragment() {

    lateinit var mFragmentPagerAdapter: BookingFragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int = R.layout.fragment_bookings

    override fun init(v: View?, savedInstanceState: Bundle?) {
        setUpToolbar(main_toolbar, R.string.booking)
        setUpTabs()
        mFragmentPagerAdapter = BookingFragmentPagerAdapter(childFragmentManager)
    }

    override fun initLoadViews() {
        pagerBooingsList.adapter = mFragmentPagerAdapter
    }

    override fun setUpEvents() {
        pagerBooingsList.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tabLayoutBooking.getTabAt(position)?.select()
            }
        })
    }

    private fun setUpTabs() {
        tabLayoutBooking.addTab(tabLayoutBooking.newTab().setText(R.string.upComing).setTag(getString(R.string.upComing)))
        tabLayoutBooking.addTab(tabLayoutBooking.newTab().setText(R.string.completed).setTag(getString(R.string.completed)))

        val onTabSelectedListener = object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.tag?.let {
                    if (it.equals(getString(R.string.upComing)))
                        pagerBooingsList.setCurrentItem(0, true)
                    else
                        pagerBooingsList.setCurrentItem(1, true)
                }

            }

        }

        tabLayoutBooking.addOnTabSelectedListener(onTabSelectedListener)
        //tabLayoutBooking.setupWithViewPager(pagerBooingsList)

    }

    companion object {
        const val TAG = "BookingFragment"

        fun newInstance(): BookingsFragment {
            val fragment = BookingsFragment()
            return fragment
        }
    }

}// Required empty public constructor
