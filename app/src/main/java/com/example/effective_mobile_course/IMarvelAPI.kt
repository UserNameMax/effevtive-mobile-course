package com.example.effective_mobile_course

import com.example.effective_mobile_course.modules.ServerAnswer
import retrofit2.http.GET
import retrofit2.http.Query


interface IMarvelAPI {
    @GET("/v1/public/characters")
    suspend fun getHeroes(@Query("ts") ts: String?,
                  @Query("apikey") apikey: String?,
                  @Query("hash") hash: String?): ServerAnswer
}