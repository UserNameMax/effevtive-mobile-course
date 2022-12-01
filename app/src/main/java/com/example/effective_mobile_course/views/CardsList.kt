package com.example.effective_mobile_course.views

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
import androidx.compose.ui.unit.dp
import com.example.effective_mobile_course.IHeroesGetter
import com.example.effective_mobile_course.modules.Result
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun CardsList(heroesGetter: IHeroesGetter){
    var heres by remember {
        mutableStateOf(listOf<Result>())
    }

    LaunchedEffect(Unit) {
        heres = heroesGetter.getHeroes()!!
    }
    val lazyListState: LazyListState = rememberLazyListState()

    LazyRow(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        flingBehavior = rememberSnapperFlingBehavior(lazyListState),
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(heres.size) {i->
            if(heres.isEmpty()){
                card()
            }
            else {
                card(heres[i])
            }

        }
    }
}