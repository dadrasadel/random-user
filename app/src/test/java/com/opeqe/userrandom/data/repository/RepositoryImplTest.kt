package com.opeqe.userrandom.data.repository

import com.opeqe.userrandom.data.model.User
import com.opeqe.userrandom.utility.CustomResponse
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.verify
import kotlin.random.Random


@RunWith(MockitoJUnitRunner::class)
class RepositoryImplTest {
    @Mock
    lateinit var repository: Repository

    @Mock
    lateinit var pokemonResult: User


    @Test
    fun `pokemon expect valid return`() {
        //Given
        val response = flowOf(CustomResponse.success(pokemonResult))
        BDDMockito.given(repository.getUser()).willReturn(response)
        //when
        val result = repository.getUser()
        //then
        assertEquals(result, response)
    }
    @Test
    fun `pokemon expect valid data`() {
        //Given
        val response = flowOf(CustomResponse.success(pokemonResult))
        BDDMockito.given(repository.getUser()).willReturn(response)
        //when
        val result = repository.getUser()
        //then
        assertNotNull(result)
    }
    @Test
    fun `repository expext pokemon method call`() {
        //Given
        //when
        repository.getUser()
        //then
        verify(repository).getUser()
    }

}