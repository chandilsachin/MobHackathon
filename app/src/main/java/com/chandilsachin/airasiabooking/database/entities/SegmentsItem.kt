package com.chandilsachin.airasiabooking.database.entities


import com.google.gson.annotations.SerializedName


data class SegmentsItem(

	@field:SerializedName("FlightDesignator")
	val flightDesignator: FlightDesignator? = null,

	@field:SerializedName("DepartureTime")
	val departureTime: String? = null,

	@field:SerializedName("ArrivalStation")
	val arrivalStation: String? = null,

	@field:SerializedName("DepartureStation")
	val departureStation: String? = null,

	@field:SerializedName("ArrivalTime")
	val arrivalTime: String? = null
)