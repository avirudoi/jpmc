package com.example.jpmc.di

import android.content.Context
import androidx.room.Room
import com.example.jpmc.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "app_db"

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext applicationContext: Context): AppDataBase {
        return Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
}