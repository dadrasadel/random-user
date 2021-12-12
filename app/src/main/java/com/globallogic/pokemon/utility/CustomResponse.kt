package com.globallogic.pokemon.utility

data class CustomResponse<out T>(val status: Status, val data:T?=null, val message:String?=null) {
    companion object {
        fun <T> success(data: T?): CustomResponse<T> = CustomResponse(Status.SUCCESS, data, null)
        fun <T> error(message: String): CustomResponse<T> =
            CustomResponse(Status.ERROR, null, message)
        fun <T> loading(): CustomResponse<T> = CustomResponse(Status.LOADING)
        fun <T> fail(): CustomResponse<T> = CustomResponse(Status.Fail)
    }
    enum class Status(){
        SUCCESS,
        ERROR,
        LOADING,
        Fail
    }
}