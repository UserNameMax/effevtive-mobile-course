package com.example.effective_mobile_course.HeroesGetter

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.effective_mobile_course.utils.Hashing
import com.example.effective_mobile_course.SourceData.IMarvelAPI
import com.example.effective_mobile_course.ValueToHero
import com.example.effective_mobile_course.models.Hero
import com.example.effective_mobile_course.models.ServerAnswer
import retrofit2.Retrofit

class InternetHeroesGetter constructor(retrofit:Retrofit): IHeroesGetter {

    private companion object{
        var marvelAPI: IMarvelAPI? = null
    }

    val retrofit_:Retrofit
    init{
        retrofit_=retrofit
        if (marvelAPI == null){
            marvelAPI = retrofit_.create(IMarvelAPI::class.java)
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getHeroes(): List<Hero>? {
        val response: ServerAnswer? = marvelAPI?.getHeroes()
        val heroes= response?.data?.results?.map { ValueToHero(it) }
        return heroes
    }
}