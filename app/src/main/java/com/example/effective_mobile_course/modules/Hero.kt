package com.example.effective_mobile_course.modules

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hero")
data class Hero (
    @PrimaryKey var id:Int,
    var name:String,
    var imageURL: String,
    var description:String,
    var color: Long
    ){
    fun getColor():Color{
        return Color(color);
    }
}