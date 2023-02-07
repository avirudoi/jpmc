package com.example.jpmc.api

import com.example.jpmc.data.SchoolInfo

interface ApiDetailProvider {

    suspend fun getSchoolInfo(id:String): List<SchoolInfo>
}