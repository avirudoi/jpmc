package com.example.jpmc.api

import com.example.jpmc.data.SchoolInfo
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class ApiDetailProviderImpl @Inject constructor(
    private val schoolsApi: SchoolsApi
):ApiDetailProvider {

    override suspend fun getSchoolInfo(id:String): List<SchoolInfo> {
        val apiResponse =  schoolsApi.getSchoolDetail(id).execute()
        return if(apiResponse.isSuccessful){
            apiResponse.body()?: throw ApiError.NetworkTimeout
        }else{
            throw errorMessage(apiResponse)
        }
    }

    //Move error handling to generic place
    private fun errorMessage(errorResponse: Response<*>?): ApiError {
        val errorBody = errorResponse?.errorBody()?.string()
        val json = JSONObject(errorBody)
        val errorMessage = json.getString("error")
        return ApiError.ErrorMessage(errorMessage)
    }
}