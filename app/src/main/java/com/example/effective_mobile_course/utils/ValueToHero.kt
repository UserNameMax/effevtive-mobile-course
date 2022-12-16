package com.example.effective_mobile_course

import com.example.effective_mobile_course.models.Hero
import com.example.effective_mobile_course.models.Result
import kotlin.random.Random

fun ValueToHero(value:Result):Hero{
    return Hero(
        id = value.id,
        name = value.name,
        imageURL = value.thumbnail.path+"."+value.thumbnail.extension,
        description = value.description,
        color = Random.nextLong(0xFFFFFFFF)
    )
}