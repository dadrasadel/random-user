package com.globallogic.pokemon.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Animated(
    @Expose
    @SerializedName("back_default")
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    @Expose
    @SerializedName("front_default")
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)