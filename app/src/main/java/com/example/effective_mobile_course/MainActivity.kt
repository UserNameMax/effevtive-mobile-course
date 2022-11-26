package com.example.effective_mobile_course

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.effective_mobile_course.ui.theme.EffectivemobilecourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectivemobilecourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    mainScreen();
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun mainScreen() {
    Surface(color = MaterialTheme.colors.error){
        Column {
            Image(
                painter = painterResource(R.drawable.marvel),
                contentDescription = "Contact profile picture"
            )
            Text(text = "Chose your hero")
            LazyRow{
                items(5) {
                    card();
                }
            }
        }
    }
}

@Composable
fun card(){
    Image(
        painter = painterResource(R.drawable.marvel),
        contentDescription = "Contact profile picture"
    )
}
