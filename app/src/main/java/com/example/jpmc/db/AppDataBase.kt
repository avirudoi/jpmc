package com.example.jpmc.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jpmc.data.database.SchoolEntity

@Database(entities = [SchoolEntity::class], version = 1)
abstract class AppDataBase:RoomDatabase() {

    abstract fun schoolDao(): SchoolDao

}