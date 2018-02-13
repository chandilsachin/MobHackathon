package com.chandilsachin.airasiabooking.database.entities


import com.google.gson.annotations.SerializedName


data class FlightDesignator(

	@field:SerializedName("FlightNumber")
	val flightNumber: String? = null
)