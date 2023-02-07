package com.example.jpmc.data.mapper

import com.example.jpmc.data.School
import com.example.jpmc.data.database.SchoolEntity


internal fun SchoolEntity.toSchoolModel(): School = School(
    dbn = id,
    schoolName = schoolName,
    phoneNumber = phoneNumber,
    schoolEmail = schoolEmail,
    location = location,
    website = website
)

internal fun School.toSchoolEntityModel(): SchoolEntity = SchoolEntity(
    id = dbn,
    schoolName = schoolName,
    phoneNumber = phoneNumber?:"",
    schoolEmail = schoolEmail?:"",
    location = location?:"",
    website = website?:""
)

