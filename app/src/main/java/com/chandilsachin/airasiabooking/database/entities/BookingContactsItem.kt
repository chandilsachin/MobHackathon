package com.chandilsachin.airasiabooking.database.entities


import com.google.gson.annotations.SerializedName


data class BookingContactsItem(

	@field:SerializedName("OtherPhone")
	val otherPhone: String? = null,

	@field:SerializedName("WorkPhone")
	val workPhone: Any? = null,

	@field:SerializedName("HomePhone")
	val homePhone: String? = null,

	@field:SerializedName("EmailAddress")
	val emailAddress: String? = null,

	@field:SerializedName("Name")
	val name: Name? = null
)