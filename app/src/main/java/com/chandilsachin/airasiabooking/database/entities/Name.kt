package com.chandilsachin.airasiabooking.database.entities


import com.google.gson.annotations.SerializedName


data class Name(

	@field:SerializedName("FirstName")
	val firstName: String? = null,

	@field:SerializedName("Title")
	val title: String? = null,

	@field:SerializedName("LastName")
	val lastName: String? = null,

	@field:SerializedName("MiddleName")
	val middleName: Any? = null
)