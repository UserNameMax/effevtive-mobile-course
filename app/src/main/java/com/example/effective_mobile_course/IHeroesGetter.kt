package com.example.effective_mobile_course

import com.example.effective_mobile_course.modules.Result

interface IHeroesGetter {
    suspend fun getHeroes(): List<Result>?
}