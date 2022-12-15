package com.example.effective_mobile_course.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.effective_mobile_course.R
import com.example.effective_mobile_course.models.Hero


@Composable
fun card(){
    Image(
        painter = painterResource(R.drawable.marvel),
        contentDescription = "Contact profile picture"
    )
}

@Composable
fun card(card: Hero, onNavigate: (Hero)->Unit){
    Box(
        Modifier
            .height((400).dp)
            .width((320).dp)){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(card.imageURL)
                .crossfade(true)
                .build(),
            contentDescription = card.name,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
                .clickable(onClick = {onNavigate(card)})
        )
        Box(
            Modifier.align(Alignment.TopStart).fillMaxHeight()
        ){
            Text(
                text = card.name,
                color = Color.White,
            )
        }

    }

}
