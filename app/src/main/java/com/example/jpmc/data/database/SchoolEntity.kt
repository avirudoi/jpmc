package com.example.jpmc.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "schools_table",
    indices = [Index(value = ["id"], unique = true)]
)
data class SchoolEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "school_name")
    val schoolName: String,

    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,

    @ColumnInfo(name = "school_email")
    val schoolEmail: String,

    @ColumnInfo(name = "location")
    val location: String,

    @ColumnInfo(name = "website")
    val website: String,
)


