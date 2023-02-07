package com.example.jpmc.di

import com.example.jpmc.api.*
import com.example.jpmc.db.SchoolRoomProvider
import com.example.jpmc.db.SchoolRoomProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun ApiListProviderImpl(implementation: ApiListProviderImpl): ApiListProvider

    @Binds
    abstract fun apiDetailProviderImpl(implementation: ApiDetailProviderImpl): ApiDetailProvider

    @Binds
    abstract fun bindsPersistenceDataSource(implementation: SchoolRoomProviderImpl): SchoolRoomProvider

}