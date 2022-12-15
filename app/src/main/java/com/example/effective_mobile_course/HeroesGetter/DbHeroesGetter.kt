package com.example.effective_mobile_course.HeroesGetter

import com.example.effective_mobile_course.SourceData.dbClient
import com.example.effective_mobile_course.models.Hero

class DbHeroesGetter() : IHeroesGetter {

    override suspend fun getHeroes(): List<Hero>? {
        return dbClient().getDao().getAll()
    }
}