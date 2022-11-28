package com.example.effective_mobile_course

import androidx.compose.runtime.LaunchedEffect
import com.example.effective_mobile_course.modules.Result
import com.example.effective_mobile_course.modules.ServerAnswer
import retrofit2.Retrofit

class InternetHeroesGetter constructor(retrofit:Retrofit):IHeroesGetter {

    private companion object{
        var marvelAPI:IMarvelAPI? = null
    }

    val retrofit_:Retrofit

    val PRIVATE_KEY_MARVEL="fabe39ab80049ea50c65e54717ff8d8441d35022"
    val PUBLIC_KEY_MARVEL="07b94bf303de475b49b2c537705e2ef3"
    val hash:String
    init{
        retrofit_=retrofit
        hash = Hashing.md5("${1}${PRIVATE_KEY_MARVEL}${PUBLIC_KEY_MARVEL}")
    }
    override suspend fun getHeroes(): List<Result>? {
        if (marvelAPI == null)
            marvelAPI = retrofit_.create(IMarvelAPI::class.java)
        val response: ServerAnswer? = marvelAPI?.getHeroes("1",PUBLIC_KEY_MARVEL,hash)
        return response?.data?.results
    }
}