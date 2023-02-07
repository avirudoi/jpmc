package com.example.jpmc.db

import com.example.jpmc.data.School

interface SchoolRoomProvider {

    fun saveUpdateSchool(school: School)

    fun getSchoolInfo(): List<School>
}