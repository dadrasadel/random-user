package com.opeqe.userrandom.data.network

import com.opeqe.userrandom.utility.CustomResponse
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


suspend fun <T> getResult(call: suspend () -> Response<T>): CustomResponse<T> {
    return try {
        val response = call()
        if (response.isSuccessful || response.code() == 201) {
            val body = response.body()
            return if (body != null) CustomResponse.success(body)
            else return CustomResponse.error(response.message())
        }
        return CustomResponse.error(response.message())
    } catch (e: Exception) {
        when (e) {
            is UnknownHostException -> {
                CustomResponse.fail()
            }
            is SocketTimeoutException -> {
                CustomResponse.fail()
            }
            is ConnectException -> {
               CustomResponse.fail()
            }
            else -> CustomResponse.error(e.message!!)
        }
    }
}
