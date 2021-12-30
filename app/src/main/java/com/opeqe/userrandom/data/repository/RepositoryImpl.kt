package com.opeqe.userrandom.data.repository

import com.opeqe.userrandom.data.model.User
import com.opeqe.userrandom.data.network.ApiServices
import com.opeqe.userrandom.data.network.getResult
import com.opeqe.userrandom.utility.CustomResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiServices) : Repository {
    override fun getUser() = flow {
        emit(getResult { apiService.getUser() })
    }
}