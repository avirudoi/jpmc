package com.example.jpmc.api

import com.example.jpmc.data.School

interface ApiListProvider {

    suspend fun getSchools(): List<School>
}