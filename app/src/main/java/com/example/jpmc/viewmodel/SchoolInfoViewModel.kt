package com.example.jpmc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.jpmc.api.ApiDetailProvider
import com.example.jpmc.api.ApiDetailProviderImpl
import com.example.jpmc.data.School
import com.example.jpmc.data.SchoolInfo
import com.example.jpmc.util.Coroutine
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SchoolInfoViewModel @Inject constructor (
    val api: ApiDetailProvider,
    val savedStateHandle: SavedStateHandle
    ):ViewModel() {

    val id: String = savedStateHandle.get<String>(SCHOOL_ID_SAVED_STATE_KEY)!!
    private val _schoolInfo = MutableLiveData<SchoolInfo>()
    val schoolInfo: LiveData<SchoolInfo> = _schoolInfo

    init {
        fetchSchoolInfo()
    }

    fun fetchSchoolInfo(){
        Coroutine.io {
            api.getSchoolInfo(id).let {
                if(it.size >0){
                    _schoolInfo.postValue(it.get(0))
                }else{
                    //handle Empty Array
                    // Display some error pop up
                    // We can create a Ui Model that have an error property
                }
            }
        }
    }

    companion object {
        private const val SCHOOL_ID_SAVED_STATE_KEY = "schoolId"
    }

}