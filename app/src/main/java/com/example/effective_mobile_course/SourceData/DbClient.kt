package com.example.effective_mobile_course.SourceData

import android.content.Context
import androidx.room.Room
import com.example.effective_mobile_course.models.AppDatabase
import com.example.effective_mobile_course.models.UserDao

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
        applicationContext =context
    }
}