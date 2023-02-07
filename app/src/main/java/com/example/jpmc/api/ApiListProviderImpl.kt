package com.example.jpmc.api

import com.example.jpmc.data.School
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class ApiListProviderImpl @Inject constructor(
    private val schoolsApi: SchoolsApi
):ApiListProvider {

    override suspend fun getSchools(): List<School> {
        val apiResponse =  schoolsApi.getSchoolList()
        return if(apiResponse.isSuccessful){
            apiResponse.body()?: throw ApiError.NetworkTimeout
        }else{
            throw errorMessage(apiResponse)
        }
    }

    private fun errorMessage(errorResponse: Response<*>?): ApiError {
        val errorBody = errorResponse?.errorBody()?.string()
        val json = JSONObject(errorBody)
        val errorMessage = json.getString("error")
        return ApiError.ErrorMessage(errorMessage)
    }
}