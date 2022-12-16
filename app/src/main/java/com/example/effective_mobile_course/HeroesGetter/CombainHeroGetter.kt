package com.example.effective_mobile_course.HeroesGetter

import com.example.effective_mobile_course.RetrofitHttpClient
import com.example.effective_mobile_course.SourceData.dbClient
import com.example.effective_mobile_course.models.Hero

class CombainHeroGetter: IHeroesGetter {
    override suspend fun getHeroes(): List<Hero>? {
        val internetGetter = InternetHeroesGetter(RetrofitHttpClient().getRetrofit())
        val dbGetter = DbHeroesGetter()
        var heroes:List<Hero>?
        try{
            heroes=internetGetter.getHeroes()
            val db = dbClient().getDao()
            val dbHeroes = dbGetter.getHeroes()
            if (dbHeroes!=null){
                for (hero in dbHeroes){
                    if (heroes?.find { it == hero } == null){
                        db.delete(hero)
                    }
                }
                for (hero in heroes!!){
                    if (dbHeroes.find { it == hero } == null){
                        db.insert(hero)
                    }
                }
            }
        }
        catch (e: Exception){
            try{
                heroes = dbGetter.getHeroes()
            }
            catch (e: Exception){
                return null
            }

        }
        return heroes
    }

}