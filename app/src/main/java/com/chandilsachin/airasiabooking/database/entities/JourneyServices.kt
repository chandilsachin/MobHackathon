package com.chandilsachin.airasiabooking.database.entities


import com.google.gson.annotations.SerializedName


data class JourneyServices(

        @field:SerializedName("Segments")
        val segments: List<SegmentsItem>? = null
)