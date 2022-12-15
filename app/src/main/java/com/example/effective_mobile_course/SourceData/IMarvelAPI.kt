package com.example.effective_mobile_course.SourceData

import com.example.effective_mobile_course.models.ServerAnswer
import retrofit2.http.GET
import retrofit2.http.Query


interface IMarvelAPI {
    @GET("/v1/public/characters")
    suspend fun getHeroes(): ServerAnswer
}