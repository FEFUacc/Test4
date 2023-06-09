package com.maskalor.myapplication.data

import com.maskalor.myapplication.data.room.dao.TaskListDao
import com.maskalor.myapplication.data.room.entity.TaskListEntity
import com.maskalor.myapplication.domain.TaskListRepository
import com.maskalor.myapplication.domain.models.TaskList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskListRepositoryImpl(private val taskListDao: TaskListDao) : TaskListRepository {

    private val mapper = Mapper()

//    init {
//        for (i in 0..10) {
//            GlobalScope.launch {
//                addTaskList(TaskList("NAME $i"))
//            }
//        }
//    }

    override suspend fun addTaskList(taskList: TaskList) {
        taskListDao.addTaskList(mapper.taskListToTaskListEntity(taskList))
    }

    override suspend fun deleteTaskList(taskList: TaskList) {
        taskListDao.deleteTaskList(mapper.taskListToTaskListEntity(taskList))
    }

    override suspend fun updateTaskList(taskList: TaskList) {
        taskListDao.updateTaskList(mapper.taskListToTaskListEntity(taskList))
    }

    override suspend fun getAllTaskLists(): List<TaskList> {
        return taskListDao.getAllTaskLists().map {
            TaskList(it.name, it.id)
        }
    }
}