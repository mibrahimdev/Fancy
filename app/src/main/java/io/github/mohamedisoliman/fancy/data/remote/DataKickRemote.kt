package io.github.mohamedisoliman.fancy.data.remote

import io.github.mohamedisoliman.fancy.data.entities.Product
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * Created by Mohamed Ibrahim on 3/2/20.
 */
const val END_POINT = "https://www.datakick.org/api/"

object Remote {

    val dataKickRemote = makeDataKickRemote()
}


fun makeDataKickRemote(): DataKickRemote {

    val retrofit = Retrofit.Builder()
        .baseUrl(END_POINT)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(makeOkHttpClient())
        .build()

    return retrofit.create(DataKickRemote::class.java)
}

fun makeOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient.Builder().addInterceptor(interceptor).build()
}

interface DataKickRemote {

    @GET("items")
    suspend fun fetchProducts(): List<Product>

    @GET("api/items/{id}")
    suspend fun fetchProductDetails(@Path("id") id: Int)
}
