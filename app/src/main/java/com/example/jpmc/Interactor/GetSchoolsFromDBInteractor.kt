package com.example.jpmc.Interactor

import com.example.jpmc.data.School
import com.example.jpmc.db.SchoolRoomProvider
import javax.inject.Inject

class GetSchoolsFromDBInteractor @Inject constructor(
    val schoolRoomProvider: SchoolRoomProvider
) {

    fun execute(): List<School> {
        return schoolRoomProvider.getSchoolInfo()
    }
}