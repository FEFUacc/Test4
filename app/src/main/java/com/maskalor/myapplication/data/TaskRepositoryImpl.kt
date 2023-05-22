package com.maskalor.myapplication.data

import com.maskalor.myapplication.data.room.dao.TaskDao
import com.maskalor.myapplication.domain.TaskRepository
import com.maskalor.myapplication.domain.models.Task
import com.maskalor.myapplication.domain.models.TaskList

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {

    private val mapper = Mapper()

    override suspend fun addTask(task: Task) {
        taskDao.addTask(mapper.taskToTaskEntity(task))
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(mapper.taskToTaskEntity(task))
    }

    override suspend fun getTasksFromTaskList(taskList: TaskList): List<Task> {
        return taskDao.getTasksFromTaskList(taskList.id).map {
            mapper.taskEntityToTask(it)
        }
    }

}