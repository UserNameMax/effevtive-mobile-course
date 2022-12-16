package com.example.effective_mobile_course.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.effective_mobile_course.views.MainScreen.MainScreenViewModel
import com.example.effective_mobile_course.views.MainScreen.MainScreenUIState
import com.example.effective_mobile_course.RememberStateWithLifecycle
import com.example.effective_mobile_course.models.Hero

@Composable
fun MainScreen(dataViewModel: MainScreenViewModel, onNavigate:(Hero)->Unit) {

    val state = RememberStateWithLifecycle(dataViewModel.state)

    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)){
        Triangle(color = when (state.value.state) {
            MainScreenUIState.states.Load -> Color.Blue
            MainScreenUIState.states.Loaded -> state.value.getCurentHero().getColor()
            else -> Color.Black
        })
        Triangle(color = if(state.value.state == MainScreenUIState.states.Loaded) state.value.getCurentHero().getColor()
        else Color.Blue)
        Column {
            Header()
            if (state.value.state == MainScreenUIState.states.Loaded){
                CardsList(state.value.heroes, {dataViewModel.onSwipe(it)}, onNavigate )
            }
        }
    }
}
