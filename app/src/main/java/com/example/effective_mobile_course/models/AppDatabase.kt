package com.example.effective_mobile_course.models

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Hero::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}