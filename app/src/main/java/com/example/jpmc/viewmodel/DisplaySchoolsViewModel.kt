package com.example.jpmc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.jpmc.Interactor.GetSchoolsFromDBInteractor
import com.example.jpmc.api.ApiListProviderImpl
import com.example.jpmc.data.School
import com.example.jpmc.repository.SchoolViewRepository
import com.example.jpmc.util.Coroutine
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DisplaySchoolsViewModel @Inject constructor (
    val repo: SchoolViewRepository,
    val getSchoolsFromDBInteractor: GetSchoolsFromDBInteractor,
    val savedStateHandle: SavedStateHandle
    ):ViewModel() {

    private val _schools = MutableLiveData<List<School>>()
    val schools: LiveData<List<School>> = _schools

    init {
        fetchSchools()
    }

    fun refresh(){
        repo.syncSchools()
        Coroutine.io {
            _schools.postValue(getSchoolsFromDBInteractor.execute())
        }
    }

    fun fetchSchools(){
        Coroutine.io {
            _schools.postValue(getSchoolsFromDBInteractor.execute())
        }
        refresh()
    }
}