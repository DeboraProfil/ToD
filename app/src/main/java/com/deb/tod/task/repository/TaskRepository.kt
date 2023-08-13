package com.deb.tod.task.repository

import android.content.Context
import com.deb.tod.task.data.Task
import com.deb.tod.task.data.datasource.TaskDAO
import com.deb.tod.utils.DatabaseBuilder

class TaskRepository(private val context: Context): TaskDAO {

    private val database by lazy {
        DatabaseBuilder(context).buildDatabase().build()
    }
    override suspend fun saveTask(task: Task): Long {
        return database.taskDAO().saveTask(task)
    }

    override fun getTask(): List<Task> {
        return database.taskDAO().getTask()
    }

    override fun removeTask(task: Task) {
        return database.taskDAO().removeTask(task)
    }
}