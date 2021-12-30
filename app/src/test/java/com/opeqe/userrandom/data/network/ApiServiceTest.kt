package com.opeqe.userrandom.data.network

import com.opeqe.userrandom.data.model.User
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
    lateinit var userResult: User

    @Test
    fun `pokemon work correct`() = runBlocking {
        //Given
        val id = Random.nextInt(0, 150)
        val response = Response.success(userResult)
        BDDMockito.given(apiServices.getUser()).willReturn(response)
        //when
        val result = apiServices.getUser()
        //then
        Assert.assertEquals(result, response)
    }
    @Test
    fun `pokemon expect valid data`() = runBlocking {
        //Given
        val id = Random.nextInt(0, 150)
        val response = Response.success(userResult)
        BDDMockito.given(apiServices.getUser()).willReturn(response)
        //when
        val result = apiServices.getUser()
        //then
        Assert.assertNotNull(result)
        Assert.assertNotNull(id)
    }
    @Test
    fun `ApiServices expext methodCall`():Unit = runBlocking {
        //Given
        val id = Random.nextInt(0, 150)
        //when
        apiServices.getUser()
        //then
        Mockito.verify(apiServices).getUser()
    }

}