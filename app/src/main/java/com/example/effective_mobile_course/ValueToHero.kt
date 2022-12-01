package com.example.effective_mobile_course

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import com.example.effective_mobile_course.modules.Hero
import com.example.effective_mobile_course.modules.Result
import kotlin.random.Random
import kotlin.random.nextULong

@RequiresApi(Build.VERSION_CODES.O)
fun ValueToHero(value:Result):Hero{
    return Hero(
        name = value.name,
        imageURL = value.thumbnail.path+"."+value.thumbnail.extension,
        description = value.description,
        color = Color(Random.nextLong(0xFFFFFFFF))
    )
}