package com.example.effective_mobile_course.modules

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM hero")
    fun getAll(): List<Hero>

    @Insert
    fun insertAll( heroes: List<Hero>)

    @Delete
    fun delete(hero: Hero)
}