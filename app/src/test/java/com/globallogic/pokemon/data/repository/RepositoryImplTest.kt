package com.globallogic.pokemon.data.repository

import com.globallogic.pokemon.data.model.PokemonResult
import com.globallogic.pokemon.utility.CustomResponse
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import kotlin.random.Random


@RunWith(MockitoJUnitRunner::class)
class RepositoryImplTest {
    @Mock
    lateinit var repository: Repository

    @Mock
    lateinit var pokemonResult: PokemonResult


    @Test
    fun `pokemon expect valid return`() {
        //Given
        val id = Random.nextInt(0, 150)
        val response = flowOf(CustomResponse.success(pokemonResult))
        BDDMockito.given(repository.getPokemon(id)).willReturn(response)
        //when
        val result = repository.getPokemon(id)
        //then
        assertEquals(result, response)
    }
    @Test
    fun `pokemon expect valid data`() {
        //Given
        val id = Random.nextInt(0, 150)
        val response = flowOf(CustomResponse.success(pokemonResult))
        BDDMockito.given(repository.getPokemon(id)).willReturn(response)
        //when
        val result = repository.getPokemon(id)
        //then
        assertNotNull(result)
        assertNotNull(id)
    }
    @Test
    fun `repository expext pokemon method call`() {
        //Given
        val id = Random.nextInt(0, 150)
        //when
        repository.getPokemon(id)
        //then
        verify(repository).getPokemon(id)
    }

}