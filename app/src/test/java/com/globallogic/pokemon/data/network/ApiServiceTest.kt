package com.globallogic.pokemon.data.network

import com.globallogic.pokemon.data.model.PokemonResult
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import kotlin.random.Random

@RunWith(MockitoJUnitRunner::class)
class ApiServiceTest {

    @Mock
    lateinit var apiServices: ApiServices

    @Mock
    lateinit var pokemonResult: PokemonResult

    @Test
    fun `pokemon work correct`() = runBlocking {
        //Given
        val id = Random.nextInt(0, 150)
        val response = Response.success(pokemonResult)
        BDDMockito.given(apiServices.getPokemon(id)).willReturn(response)
        //when
        val result = apiServices.getPokemon(id)
        //then
        Assert.assertEquals(result, response)
    }
    @Test
    fun `pokemon expext valid data`() = runBlocking {
        //Given
        val id = Random.nextInt(0, 150)
        val response = Response.success(pokemonResult)
        BDDMockito.given(apiServices.getPokemon(id)).willReturn(response)
        //when
        val result = apiServices.getPokemon(id)
        //then
        Assert.assertNotNull(result)
        Assert.assertNotNull(id)
    }
    @Test
    fun `ApiServices expext methodCall`():Unit = runBlocking {
        //Given
        val id = Random.nextInt(0, 150)
        //when
        apiServices.getPokemon(id)
        //then
        Mockito.verify(apiServices).getPokemon(id)
    }

}