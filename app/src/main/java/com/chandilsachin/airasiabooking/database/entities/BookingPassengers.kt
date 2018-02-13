package com.chandilsachin.airasiabooking.database.entities


import com.google.gson.annotations.SerializedName


data class BookingPassengers(

	@field:SerializedName("Infants")
	val infants: List<InfantsItem?>? = null,

	@field:SerializedName("Adults")
	val adults: List<AdultsItem?>? = null
)