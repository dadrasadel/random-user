package com.opeqe.userrandom.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.opeqe.userrandom.data.model.User
import com.opeqe.userrandom.data.repository.Repository
import com.opeqe.userrandom.ui.base.BaseViewModel
import com.opeqe.userrandom.utility.CustomResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    private val dipatcher: CoroutineDispatcher
) : BaseViewModel() {
    private val _resultData = MutableLiveData<CustomResponse<User>>()
    val resultData: LiveData<CustomResponse<User>> = _resultData
    init {
        getUser()
    }
    private fun getUser(){
        viewModelScope.launch {
            withContext(dipatcher){
                repository.getUser()
                    .collect {
                        _resultData.postValue(it)
                    }
            }
        }
    }
}