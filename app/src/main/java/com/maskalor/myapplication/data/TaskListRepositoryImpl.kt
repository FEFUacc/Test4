package com.maskalor.myapplication.data

import com.maskalor.myapplication.data.room.TaskListDao
import com.maskalor.myapplication.data.room.TaskListEntity
import com.maskalor.myapplication.domain.TaskListRepository
import com.maskalor.myapplication.domain.models.TaskList

class TaskListRepositoryImpl(private val taskListDao: TaskListDao) : TaskListRepository {
    override suspend fun addTaskList(taskList: TaskList) {
        taskListDao.addTaskList(taskListToTaskListEntity(taskList))
    }

    override suspend fun deleteTaskList(taskList: TaskList) {
        taskListDao.deleteTaskList(taskListToTaskListEntity(taskList))
    }

    override suspend fun updateTaskList(taskList: TaskList) {
        taskListDao.updateTaskList(taskListToTaskListEntity(taskList))
    }

    override suspend fun getAllTaskLists(): List<TaskList> {
        return taskListDao.getAllTaskLists().map {
            TaskList(it.name, it.id)
        }
    }

    private fun taskListToTaskListEntity(taskList: TaskList) : TaskListEntity {
        return TaskListEntity(taskList.id, taskList.name)
    }
}