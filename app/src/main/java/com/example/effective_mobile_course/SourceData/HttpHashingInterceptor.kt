package com.example.effective_mobile_course.SourceData

import com.example.effective_mobile_course.utils.Hashing
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import kotlin.random.Random
import kotlin.random.nextUInt


class HttpHashingInterceptor:Interceptor {

    val PRIVATE_KEY_MARVEL="fabe39ab80049ea50c65e54717ff8d8441d35022"
    val PUBLIC_KEY_MARVEL="07b94bf303de475b49b2c537705e2ef3"
    
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val originalHttpUrl: HttpUrl = original.url

        val time = Random.nextUInt()
        val hash = Hashing.md5("${time}${PRIVATE_KEY_MARVEL}${PUBLIC_KEY_MARVEL}")

        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("ts", "$time")
            .addQueryParameter("apikey", PUBLIC_KEY_MARVEL)
            .addQueryParameter("hash", hash)
            .build()
        val newRequest = original.newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(newRequest)
    }
}