package com.example.effective_mobile_course.views

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.effective_mobile_course.InternetHeroesGetter
import com.example.effective_mobile_course.R
import com.example.effective_mobile_course.RetrofitHttpClient
import com.example.effective_mobile_course.modules.Result
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior


@Preview(showBackground = true)
@Composable
fun mainScreen() {
    Surface(modifier = Modifier.fillMaxSize().background(Color.Red)){
        triangle(color = Color.White)
        Column {
            header()
            CardsList(InternetHeroesGetter(RetrofitHttpClient().getRetrofit()))
        }
    }
}
