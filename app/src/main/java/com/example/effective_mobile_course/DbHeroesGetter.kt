package com.example.effective_mobile_course

import com.example.effective_mobile_course.modules.Hero

class DbHeroesGetter() : IHeroesGetter {

    override suspend fun getHeroes(): List<Hero>? {
        return dbClient().getDao().getAll()
    }
}