package com.example.jpmc.api

import com.example.jpmc.data.School
import com.example.jpmc.data.SchoolInfo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SchoolsApi {

    @GET("s3k6-pzi2.json")
    suspend fun getSchoolList(
    ): Response<List<School>>

    @GET("f9bf-2cp4.json")
    fun getSchoolDetail(
        @Query("dbn") string: String): Call<List<SchoolInfo>>

}