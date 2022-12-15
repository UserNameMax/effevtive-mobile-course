package com.example.effective_mobile_course

import com.example.effective_mobile_course.SourceData.HttpHashingInterceptor
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
                .addInterceptor(HttpHashingInterceptor())
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