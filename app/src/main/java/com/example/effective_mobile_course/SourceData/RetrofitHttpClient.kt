package com.example.effective_mobile_course

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.math.BigInteger
import java.security.MessageDigest


class RetrofitHttpClient {

    private companion object{
        var httpLoggingInterceptor: HttpLoggingInterceptor? = null
        var retrofit :Retrofit? = null
        var httpClient: OkHttpClient? = null
    }

    val MarvelApiUrl = "http://gateway.marvel.com"
    fun getRetrofit(): Retrofit {
        if (retrofit == null){
            httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor!!)
                .build()
            retrofit = Retrofit.Builder()
                .baseUrl(MarvelApiUrl)
                .client(httpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }

        return retrofit!!
    }
}

object Hashing {
    @JvmStatic
    fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input
            .toByteArray()))
            .toString(16)
            .padStart(32, '0')
    }
}