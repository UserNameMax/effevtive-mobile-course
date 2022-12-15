package com.example.effective_mobile_course.views.MainScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.example.effective_mobile_course.HeroesGetter.CombainHeroGetter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel @RequiresApi(Build.VERSION_CODES.O) constructor() : ViewModel() {
    private var _state: MutableStateFlow<MainScreenUIState> = MutableStateFlow<MainScreenUIState>(
        MainScreenUIState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value.heroes = CombainHeroGetter().getHeroes()!!
            _state.update { _state.value.chengeState(MainScreenUIState.states.Loaded) }
        }
    }
    fun onSwipe(newIndex: Int){
        _state.update { _state.value.chengeIndex(newIndex) }
    }
}