package com.maskalor.myapplication.data.room

import androidx.room.*

@Dao
abstract class TaskListDao {
    @Insert
    abstract suspend fun addTaskList(taskListEntity: TaskListEntity)

    @Delete
    abstract suspend fun deleteTaskList(taskListEntity: TaskListEntity)

    @Update
    abstract suspend fun updateTaskList(taskListEntity: TaskListEntity)

    @Query("SELECT * FROM taskList")
    abstract suspend fun getAllTaskLists() : List<TaskListEntity>
}