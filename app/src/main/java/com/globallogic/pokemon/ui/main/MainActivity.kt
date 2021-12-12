package com.globallogic.pokemon.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.bilerplatemvvm.R
import com.example.bilerplatemvvm.databinding.ActivityMainBinding
import com.globallogic.pokemon.data.model.PokemonResult
import com.globallogic.pokemon.ui.base.BaseActivity
import com.globallogic.pokemon.utility.Commons.showErrorMessage
import com.globallogic.pokemon.utility.CustomResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeData()
        binding.btnGenerate.setOnClickListener {
            viewModel.getPokemon()
        }
    }

    private fun observeData() {
        viewModel.resultData.observe(this, {
            when (it.status) {
                CustomResponse.Status.SUCCESS -> {
                    showImageInGlide(it.data!!)
                    binding.txtName.text=it.data.name
                }
                CustomResponse.Status.ERROR -> {
                    showErrorMessage(it.message!!,this)
                }
                else->{
                    showErrorMessage(getString(R.string.NetWork_error),this)
                }
            }
        })
    }

    private fun showImageInGlide(result: PokemonResult) {
        Glide
            .with(this)
            .load(result.sprites.front_default)
            .error(R.drawable.ic_web_cloud)
            .into(binding.staticLinear.imgFront)
        Glide
            .with(this)
            .load(result.sprites.back_default)
            .error(R.drawable.ic_web_cloud)
            .into(binding.staticLinear.imgBack)

        Glide
            .with(this)
            .asGif()
            .load(result.sprites.versions.generation_v.black_white.animated.front_default)
            .error(R.drawable.ic_web_cloud)
            .into(binding.dynamicLinear.imgFront)
        Glide
            .with(this)
            .asGif()
            .load(result.sprites.versions.generation_v.black_white.animated.back_default)
            .error(R.drawable.ic_web_cloud)
            .into(binding.dynamicLinear.imgBack)


    }
}