package com.example.effective_mobile_course.views.MainScreen

import androidx.compose.runtime.Immutable
import com.example.effective_mobile_course.models.Hero

@Immutable
class MainScreenUIState() {
    enum class states{
        Load,
        Loaded,
        Error
    }

    var heroes: List<Hero> = listOf()
    var curentIndex:Int = 0
    var state = states.Load

    constructor(heroes:List<Hero>,curentIndex:Int,state: states) : this() {
        this.heroes = heroes
        this.curentIndex = curentIndex
        this.state = state
    }

    fun getCurentHero():Hero{
        return heroes[curentIndex];
    }

    fun chengeState(newState: states): MainScreenUIState {
        return MainScreenUIState(heroes,curentIndex,newState)
    }

    fun chengeIndex(newIndex:Int):MainScreenUIState{
        return MainScreenUIState(heroes,newIndex,state)
    }
}