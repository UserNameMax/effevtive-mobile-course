package com.example.effective_mobile_course.views

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.effective_mobile_course.*
import com.example.effective_mobile_course.modules.AppDatabase
import com.example.effective_mobile_course.modules.Hero

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationHost(applicationContext:Context){
    val navController = rememberNavController()
    var selectHero:Hero = Hero(-1,"Error","","", 0)
    dbClient().setApplicationContext(applicationContext)
    NavHost(navController = navController, startDestination = "mainScreen"){
        composable("mainScreen"){
            mainScreen(
                heroesGetter = CombainHeroGetter(),
                onNavigate = {
                navController.navigate("heroScreen")
                selectHero = it
            })
        }
        composable("heroScreen"){ HeroScreen(selectHero,{navController.popBackStack()}) }
    }
}