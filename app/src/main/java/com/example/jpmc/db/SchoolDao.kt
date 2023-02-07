package com.example.jpmc.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.jpmc.data.database.SchoolEntity

@Dao
interface SchoolDao {

    @Insert(onConflict = REPLACE)
    fun upsert(schoolEntity: SchoolEntity): Long

    @Query("SELECT * FROM schools_table")
    fun getAll():List<SchoolEntity>

}