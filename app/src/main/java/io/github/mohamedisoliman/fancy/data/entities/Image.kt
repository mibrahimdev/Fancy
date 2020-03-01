package io.github.mohamedisoliman.fancy.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Image(
    @Json(name = "url")
    val url: String? = ""
)