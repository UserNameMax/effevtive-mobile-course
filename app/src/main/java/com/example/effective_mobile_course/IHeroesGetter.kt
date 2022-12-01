package com.example.effective_mobile_course

import com.example.effective_mobile_course.modules.Hero

interface IHeroesGetter {
    suspend fun getHeroes(): List<Hero>?
}