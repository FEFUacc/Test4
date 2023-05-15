package com.maskalor.myapplication.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "taskList")
data class TaskListEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)