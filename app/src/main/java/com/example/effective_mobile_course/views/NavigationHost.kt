package com.example.effective_mobile_course.views

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effective_mobile_course.*
import com.example.effective_mobile_course.SourceData.dbClient
import com.example.effective_mobile_course.models.Hero
import com.example.effective_mobile_course.views.MainScreen.MainScreenViewModel

@Composable
fun NavigationHost(applicationContext:Context){
    val navController = rememberNavController()
    var selectHero:Hero = Hero(-1,"Error","","", 0)
    val dataViewModel = MainScreenViewModel()
    dbClient().setApplicationContext(applicationContext)
    NavHost(navController = navController, startDestination = "mainScreen"){
        composable("mainScreen"){
            MainScreen(
                dataViewModel = dataViewModel,
                onNavigate = {
                navController.navigate("heroScreen")
                selectHero = it
            })
        }
        composable("heroScreen"){ HeroScreen(selectHero,{navController.popBackStack()}) }
    }
}