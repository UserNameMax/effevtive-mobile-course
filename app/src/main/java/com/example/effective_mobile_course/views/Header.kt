package com.example.effective_mobile_course.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.effective_mobile_course.R

@Composable
fun header(){
    Image(
        painter = painterResource(R.drawable.marvel),
        contentDescription = "Contact profile picture"
    )
    Text(text = "Chose your hero")
    Spacer(modifier = Modifier.height(32.dp))

}