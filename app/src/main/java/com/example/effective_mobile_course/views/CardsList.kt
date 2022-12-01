package com.example.effective_mobile_course.views

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.effective_mobile_course.IHeroesGetter
import com.example.effective_mobile_course.modules.Hero
import com.example.effective_mobile_course.modules.Result
import com.example.effective_mobile_course.onSwipe
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

class CardsList {
    var index = mutableStateOf(0)

    @OptIn(ExperimentalSnapperApi::class)
    @Composable
    fun getView(heroesGetter: IHeroesGetter, onChangeIndex: (Color)-> Unit){
        var heroes by remember {
            mutableStateOf(listOf<Hero>())
        }

        LaunchedEffect(Unit) {
            heroes = heroesGetter.getHeroes()!!
        }
        val lazyListState: LazyListState = rememberLazyListState()
        val layoutInfo: LazyListSnapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState)

        LaunchedEffect(lazyListState.isScrollInProgress) {
           if (!lazyListState.isScrollInProgress) {
                val snappedItem = layoutInfo.currentItem
                if (snappedItem != null) {
                    onChangeIndex(heroes[snappedItem.index].color)
                }
            }
            Log.e("debug0",index.toString())
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
            items(heroes.size) { i->
                if(heroes.isEmpty()){
                    card()
                }
                else {
                    card(heroes[i])
                }

            }
        }
    }
}

