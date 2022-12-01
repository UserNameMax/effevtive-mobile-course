package com.example.effective_mobile_course.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.effective_mobile_course.R
import com.example.effective_mobile_course.modules.Result


@Composable
fun card(){
    Image(
        painter = painterResource(R.drawable.marvel),
        contentDescription = "Contact profile picture"
    )
}

@Composable
fun card(card: Result){
    Box(
        Modifier
            .height((400).dp)
            .width((320).dp)){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("${card.thumbnail.path}.${card.thumbnail.extension}")
                .crossfade(true)
                .build(),
            contentDescription = card.name,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = card.name,
            color = Color.Red
        )
    }

}
