package com.globallogic.pokemon.data.repository

import com.globallogic.pokemon.data.model.PokemonResult
import com.globallogic.pokemon.utility.CustomResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getPokemon(id: Int): Flow<CustomResponse<PokemonResult>>
}