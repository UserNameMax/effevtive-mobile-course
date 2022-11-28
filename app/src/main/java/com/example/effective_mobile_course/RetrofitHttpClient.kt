package com.example.effective_mobile_course

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.math.BigInteger
import java.security.MessageDigest


class RetrofitHttpClient:IHttpClient {
    val PRIVATE_KEY_MARVEL="fabe39ab80049ea50c65e54717ff8d8441d35022"
    val PUBLIC_KEY_MARVEL="07b94bf303de475b49b2c537705e2ef3"
    val MarvelApiUrl = "http://gateway.marvel.com/"
    override fun GetHero(): String {
        val hash = Hashing.md5("${1}${PRIVATE_KEY_MARVEL}${PUBLIC_KEY_MARVEL}")
        val retrofit = Retrofit.Builder()
            .baseUrl(MarvelApiUrl)
            .client(OkHttpClient().newBuilder().build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val marvelAPI = retrofit.create(IMarvelAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = marvelAPI.getHeroes("1",PUBLIC_KEY_MARVEL,hash)
        }
        return ""
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