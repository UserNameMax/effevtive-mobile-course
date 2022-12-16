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
import com.example.effective_mobile_course.*
import com.example.effective_mobile_course.models.Hero
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

    @OptIn(ExperimentalSnapperApi::class)
    @Composable
    fun CardsList(heroes:List<Hero>?, onChangeIndex: (Int)-> Unit, onNavigate: (Hero)->Unit){
        val lazyListState: LazyListState = rememberLazyListState()
        val layoutInfo: LazyListSnapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState)

        LaunchedEffect(lazyListState.isScrollInProgress) {
           if  (!lazyListState.isScrollInProgress) {
                val snappedItem = layoutInfo.currentItem
                if (snappedItem != null ) {
                    onChangeIndex(snappedItem.index)
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
            items(heroes!!.size) { i ->
                card(heroes[i],onNavigate)
            }
        }
    }

