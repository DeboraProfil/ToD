package com.deb.tod.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deb.tod.task.data.Task
import com.deb.tod.task.data.datasource.TaskDAO


@Database(entities = [Task::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun taskDAO() : TaskDAO


}