package com.example.effective_mobile_course.views.MainScreen

import androidx.lifecycle.*
import com.example.effective_mobile_course.HeroesGetter.CombainHeroGetter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {
    private var _state: MutableStateFlow<MainScreenUIState> = MutableStateFlow(MainScreenUIState())
    val state = _state.asStateFlow()
    init {
        viewModelScope.launch {
            val heroes = CombainHeroGetter().getHeroes()
            if (heroes == null){
                _state.update { _state.value.chengeState(MainScreenUIState.states.Error) }
            }
            else{
                _state.value.heroes = heroes
                _state.update { _state.value.chengeState(MainScreenUIState.states.Loaded) }
            }
        }
    }
    fun onSwipe(newIndex: Int){
        _state.update { _state.value.chengeIndex(newIndex) }
    }
}