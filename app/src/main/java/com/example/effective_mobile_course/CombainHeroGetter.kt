package com.example.effective_mobile_course

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.effective_mobile_course.modules.Hero

class CombainHeroGetter:IHeroesGetter {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getHeroes(): List<Hero>? {
        val internetGetter = InternetHeroesGetter(RetrofitHttpClient().getRetrofit())
        val dbGetter = DbHeroesGetter()
        var heroes:List<Hero>?
        try{
            heroes=internetGetter.getHeroes()
        }
        catch (e: Exception){
            heroes = dbGetter.getHeroes()
        }
        return heroes
    }

}