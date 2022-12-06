package com.example.effective_mobile_course.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.request.ImageRequest
import com.example.effective_mobile_course.modules.Hero

@Composable
fun HeroScreen(hero: Hero) {
    Box{
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(hero.imageURL)
                .crossfade(true)
                .build(),
            contentDescription = hero.name,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )
        Box(Modifier.align(Alignment.TopStart).fillMaxWidth()){
            Text(
                text = hero.name,
                color = Color.White,
            )
        }
        Box(Modifier.align(Alignment.BottomStart).fillMaxWidth()){
            Text(
                text = hero.description,
                color = Color.White,
            )
        }
    }

}