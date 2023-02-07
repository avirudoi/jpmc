package com.example.jpmc.repository

import com.example.jpmc.api.ApiListProvider
import com.example.jpmc.data.School
import com.example.jpmc.db.SchoolRoomProvider
import com.example.jpmc.util.Coroutine
import javax.inject.Inject

class SchoolViewRepository@Inject constructor (
    val api: ApiListProvider,
    val db: SchoolRoomProvider, )
{

    fun syncSchools(){
        //I would use here Rx java to make it stream
        Coroutine.io {
            val schools = api.getSchools()
            schools.forEach {  db.saveUpdateSchool(it) }
        }
    }
}