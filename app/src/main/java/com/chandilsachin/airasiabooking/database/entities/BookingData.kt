package com.chandilsachin.airasiabooking.database.entities

import com.google.gson.annotations.SerializedName

data class BookingData(

	@field:SerializedName("BookingContacts")
	val bookingContacts: List<BookingContactsItem?>? = null,

	@field:SerializedName("PNR")
	val pNR: String? = null,

	@field:SerializedName("JourneyServices")
	val journeyServices: JourneyServices? = null,

	@field:SerializedName("BookingPassengers")
	val bookingPassengers: BookingPassengers? = null,

	@field:SerializedName("BookingStatus")
	val bookingStatus: String? = null
)