package com.example.jpmc.db

import com.example.jpmc.data.School
import com.example.jpmc.data.mapper.toSchoolEntityModel
import com.example.jpmc.data.mapper.toSchoolModel
import javax.inject.Inject

class SchoolRoomProviderImpl @Inject constructor(
    private val db: AppDataBase
):SchoolRoomProvider {

    override fun saveUpdateSchool(school: School){
        db.schoolDao().upsert(school.toSchoolEntityModel())
    }

    override fun getSchoolInfo(): List<School> {
        return db.schoolDao().getAll().map { it.toSchoolModel() }
    }
}