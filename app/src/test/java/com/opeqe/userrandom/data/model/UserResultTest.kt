package com.opeqe.userrandom.data.model

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserResultTest {
    @Mock
    lateinit var info: Info
    @Mock
    lateinit var result: List<Result>
    @Test
    fun `PokemonResult show be valid data`() {
        //Given
        val name = "pokomo"
        //when
        val pokemonResult = User(info, result)
        //then
        assertNotNull(pokemonResult)
        assertNotNull(name)
    }

}