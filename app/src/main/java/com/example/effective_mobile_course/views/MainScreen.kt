package com.example.effective_mobile_course.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.effective_mobile_course.DataViewModel
import com.example.effective_mobile_course.DbHeroesGetter
import com.example.effective_mobile_course.IHeroesGetter
import com.example.effective_mobile_course.modules.Hero

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun mainScreen(dataViewModel: DataViewModel, heroesGetter: IHeroesGetter, onNavigate:(Hero)->Unit) {
    var colorNumber by remember {
        mutableStateOf(Color.Blue)
    }
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)){
        triangle(color = colorNumber)
        Column {
            header()
            getView(dataViewModel, heroesGetter, {colorNumber=it}, onNavigate )
        }
    }
}
