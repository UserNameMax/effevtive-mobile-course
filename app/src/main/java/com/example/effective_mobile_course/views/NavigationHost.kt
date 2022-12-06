package com.example.effective_mobile_course.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effective_mobile_course.modules.Hero

@Composable
fun NavigationHost(){
    val navController = rememberNavController()
    var selectHero:Hero = Hero("Error","","", Color.White)
    NavHost(navController = navController, startDestination = "mainScreen"){
        composable("mainScreen"){ mainScreen({
            navController.navigate("heroScreen")
            selectHero = it
        }) }
        composable("heroScreen"){ HeroScreen(selectHero) }
    }
}