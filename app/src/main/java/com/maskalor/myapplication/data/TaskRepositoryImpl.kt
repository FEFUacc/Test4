package com.maskalor.myapplication.data

import com.maskalor.myapplication.data.room.dao.TaskDao
import com.maskalor.myapplication.domain.TaskRepository
import com.maskalor.myapplication.domain.models.Task
import com.maskalor.myapplication.domain.models.TaskList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {

    private val mapper = Mapper()

//    init {
//        GlobalScope.launch {
//            for (i in 0..10) {
//                addTask(Task("NAME $i", "test", i+1))
//                addTask(Task("NAgdfgsdgsgME $i", "test", i+1))
//            }
//
//        }
//    }

    override suspend fun addTask(task: Task) {
        taskDao.addTask(mapper.taskToTaskEntity(task))
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(mapper.taskToTaskEntity(task))
    }

    override suspend fun getTasksFromTaskList(id: Int): List<Task> {
        return taskDao.getTasksFromTaskList(id).map {
            mapper.taskEntityToTask(it)
        }
    }

}