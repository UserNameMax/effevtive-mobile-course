package com.example.effective_mobile_course.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.effective_mobile_course.InternetHeroesGetter
import com.example.effective_mobile_course.RetrofitHttpClient


@Preview(showBackground = true)
@Composable
fun mainScreen() {
    val list by remember {
        mutableStateOf(CardsList())
    }
    var colorNumber by remember {
        mutableStateOf(Color.Blue)
    }
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)){
        triangle(color = colorNumber)
        Column {
            header()
            list.getView(InternetHeroesGetter(RetrofitHttpClient().getRetrofit()), {colorNumber=it}
            )
        }
    }
}
