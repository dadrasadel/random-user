package com.opeqe.userrandom.data.model

import java.io.Serializable

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
): Serializable