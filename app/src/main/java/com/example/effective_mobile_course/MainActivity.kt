package com.example.effective_mobile_course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.effective_mobile_course.modules.Result
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
    val getter = InternetHeroesGetter(RetrofitHttpClient().getRetrofit())

    var heres by remember {
        mutableStateOf(listOf<Result>())
    }

    LaunchedEffect(Unit) {
        heres = getter.getHeroes()!!
    }
    Surface(color = MaterialTheme.colors.error){
        Column {
                Image(
                    painter = painterResource(R.drawable.marvel),
                    contentDescription = "Contact profile picture"
                )
                Text(text = "Chose your hero")
                LazyRow {
                    items(heres.size) {i->
                        if(heres.isEmpty()){
                            card();
                        }
                        else {
                            card(heres[i])
                        }

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

@Composable
fun card(card: Result){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("${card.thumbnail.path}.${card.thumbnail.extension}")
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Text(
        text = card.name,
        color = Color.White
    )
}
