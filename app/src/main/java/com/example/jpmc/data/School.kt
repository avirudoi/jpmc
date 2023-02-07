package com.example.jpmc.data

import com.google.gson.annotations.SerializedName

data class School (
    @field:SerializedName("dbn") val dbn: String,
    @field:SerializedName("school_name") val schoolName: String,
    @field:SerializedName("phone_number") val phoneNumber: String?,
    @field:SerializedName("school_email") val schoolEmail: String?,
    @field:SerializedName("location") val location: String?,
    @field:SerializedName("website") val website: String?
        )

