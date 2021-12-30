package com.opeqe.userrandom.data.network

import com.opeqe.userrandom.data.model.*

import retrofit2.Response
import retrofit2.http.*


interface ApiServices {
    @GET("api")
    suspend fun getUser(): Response<User>

}