package com.globallogic.pokemon.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Versions(
    val generation_i: GenerationI,
    val generation_ii: GenerationIi,
    val generation_iii: GenerationIii,
    val generation_iv: GenerationIv,
    @Expose
    @SerializedName("generation-v")
    val generation_v: GenerationV,
    val generation_vi: GenerationVi,
    val generation_vii: GenerationVii,
    val generation_viii: GenerationViii
)