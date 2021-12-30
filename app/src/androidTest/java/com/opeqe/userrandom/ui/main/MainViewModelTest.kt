package com.opeqe.userrandom.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValue
import com.opeqe.userrandom.data.repository.Repository
import com.opeqe.userrandom.utility.CustomResponse
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import kotlin.random.Random

@ExperimentalCoroutinesApi
@HiltAndroidTest
class MainViewModelTest{

    @get:Rule
    val hilt=HiltAndroidRule(this)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var repository: Repository



    @Before
    fun setup(){
        hilt.inject()
//        mainViewModel=MainViewModel(repository)
    }
    /** MainViewModel Expect valid Data when call server
    * input variable:nothing
    * output variable:resultPoker
    */
    @Test
    fun notNullResponseData()= runBlocking{
        //Given
        //when
            val result=repository.getUser().asLiveData().getOrAwaitValue().data
        //then
            assertNotNull(result)
    }
    /** method return success data
    * input variable:id
    * output variable:result api
    */
    @Test
    fun methodReturnSuccessData()= runBlocking {
        //Given
        //when
            val result=repository.getUser().asLiveData().getOrAwaitValue()
        //then
            assertEquals(result.status,CustomResponse.Status.SUCCESS)
            assertNotNull(result.data)
    }


}