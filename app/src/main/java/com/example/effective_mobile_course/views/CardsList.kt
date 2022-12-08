package com.example.effective_mobile_course.views

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.repeatOnLifecycle
import com.example.effective_mobile_course.*
import com.example.effective_mobile_course.modules.Hero
import com.example.effective_mobile_course.modules.Result
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalSnapperApi::class)
    @Composable
    fun getView(dataViewModel:DataViewModel, heroesGetter: IHeroesGetter, onChangeIndex: (Color)-> Unit, onNavigate: (Hero)->Unit){
        val lazyListState: LazyListState = rememberLazyListState()
        val layoutInfo: LazyListSnapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState)
        val heroes = rememberStateWithLifecycle(dataViewModel.heroes)

        LaunchedEffect(lazyListState.isScrollInProgress) {
           if (!lazyListState.isScrollInProgress) {
                val snappedItem = layoutInfo.currentItem
                if (snappedItem != null && heroes.value!=null) {
                    onChangeIndex(heroes.value!![snappedItem.index].getColor())
                }
            }
        }
        LazyRow(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            state = lazyListState,
            flingBehavior = rememberSnapperFlingBehavior(lazyListState),
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (heroes.value!=null){
                items(heroes.value!!.size) { i ->
                    card(heroes.value!![i],onNavigate)
                }
            }
        }
    }

