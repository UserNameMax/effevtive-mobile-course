package com.example.effective_mobile_course

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.effective_mobile_course.modules.AppDatabase
import com.example.effective_mobile_course.modules.UserDao

class dbClient {
    private companion object{
        lateinit var applicationContext:Context
        lateinit var db : AppDatabase
        var dao:UserDao?=null
    }
    fun getDao():UserDao{
        if (dao == null){
            db = Room.databaseBuilder(applicationContext,AppDatabase::class.java,"heroes-base")
                .allowMainThreadQueries()
                .build()
            dao = db.userDao()
        }
        return dao!!
    }
    fun setApplicationContext(context: Context){
        applicationContext=context
    }
}