package com.chandilsachin.airasiabooking.database.entities

import com.google.gson.annotations.SerializedName

data class AdultsItem(

	@field:SerializedName("FirstName")
	val firstName: String? = null,

	@field:SerializedName("LastName")
	val lastName: String? = null,

	@field:SerializedName("Gender")
	val gender: String? = null,

	@field:SerializedName("MiddleName")
	val middleName: Any? = null
)