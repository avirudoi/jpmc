package com.example.jpmc.data

import com.google.gson.annotations.SerializedName

data class SchoolInfo (
    @field:SerializedName("dbn") val dbn: String,
    @field:SerializedName("school_name") val schoolName: String,
    @field:SerializedName("num_of_sat_test_takers") val testTakers: String,
    @field:SerializedName("sat_critical_reading_avg_score") val readingAvgScore: String,
    @field:SerializedName("sat_math_avg_score") val mathAvgScore: String,
    @field:SerializedName("sat_writing_avg_score") val writingAvgScore: String

        )

