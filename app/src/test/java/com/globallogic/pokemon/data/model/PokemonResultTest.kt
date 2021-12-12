package com.globallogic.pokemon.data.model

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PokemonResultTest {
    @Mock
    lateinit var sprites: Sprites
    @Test
    fun `PokemonResult show be valid data`() {
        //Given
        val name = "pokomo"
        //when
        val pokemonResult = PokemonResult(name, sprites)
        //then
        assertNotNull(pokemonResult)
        assertNotNull(name)
    }

}