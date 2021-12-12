package com.globallogic.pokemon.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GenerationV(
    @Expose
    @SerializedName("black-white")
    val black_white: BlackWhite
)