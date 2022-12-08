package com.example.effective_mobile_course

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.*
import com.example.effective_mobile_course.modules.Hero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DataViewModel @RequiresApi(Build.VERSION_CODES.O) constructor() : ViewModel() {
    private var _heroes: MutableStateFlow<List<Hero>?> = MutableStateFlow(null)
    val heroes = _heroes.asStateFlow()

    init {
        viewModelScope.launch {
            _heroes.update { CombainHeroGetter().getHeroes() }
        }
    }
}