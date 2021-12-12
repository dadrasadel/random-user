package com.globallogic.pokemon.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globallogic.pokemon.data.model.PokemonResult
import com.globallogic.pokemon.data.repository.Repository
import com.globallogic.pokemon.ui.base.BaseViewModel
import com.globallogic.pokemon.utility.CustomResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    private val dipatcher: CoroutineDispatcher
) : BaseViewModel() {
    private val _resultData = MutableLiveData<CustomResponse<PokemonResult>>()
    val resultData: LiveData<CustomResponse<PokemonResult>> = _resultData
    init {
        getPokemon()
    }
    fun getPokemon(){
        viewModelScope.launch {
            withContext(dipatcher){
                repository.getPokemon(Random.nextInt(0, 150))
                    .collect {
                        _resultData.postValue(it)
                    }
            }
        }
    }
}