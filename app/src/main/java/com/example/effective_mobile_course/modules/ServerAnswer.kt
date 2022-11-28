package com.example.effective_mobile_course.modules

import com.squareup.moshi.Json

data class ServerAnswer(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    @Json(name="`data`")
    val data: Data,
    val etag: String,
    val status: String
)
