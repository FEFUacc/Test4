package com.maskalor.myapplication.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskListEntity::class], version = 1)
abstract class MyDb : RoomDatabase(){
    abstract fun taskListDao() : TaskListDao
}