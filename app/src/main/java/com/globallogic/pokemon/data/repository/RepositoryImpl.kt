package com.globallogic.pokemon.data.repository

import com.globallogic.pokemon.data.model.PokemonResult
import com.globallogic.pokemon.data.network.ApiServices
import com.globallogic.pokemon.data.network.getResult
import com.globallogic.pokemon.utility.CustomResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiServices) : Repository {
    override fun getPokemon(id: Int): Flow<CustomResponse<PokemonResult>> = flow {
        emit(getResult { apiService.getPokemon(id) })
    }
}