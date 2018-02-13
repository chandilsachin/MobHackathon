package com.chandilsachin.airasiabooking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chandilsachin.airasiabooking.fragments.bookingFragment.BookingsFragment
import com.chandilsachin.notely.util.loadFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(R.id.frameFragmentContainer, BookingsFragment.newInstance(), BookingsFragment.TAG)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1)
            super.onBackPressed()
        else
            finish()
    }
}
