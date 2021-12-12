package com.globallogic.pokemon.data.network

import com.globallogic.pokemon.data.model.*

import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface ApiServices {
    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id: Int
    ): Response<PokemonResult>

}