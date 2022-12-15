package com.example.effective_mobile_course.HeroesGetter

import com.example.effective_mobile_course.models.Hero

interface IHeroesGetter {
    suspend fun getHeroes(): List<Hero>?
}