package com.opeqe.userrandom.data.repository

import com.opeqe.userrandom.data.model.User
import com.opeqe.userrandom.utility.CustomResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getUser(): Flow<CustomResponse<User>>
}