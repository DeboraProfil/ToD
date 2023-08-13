package com.deb.tod.task.data.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.deb.tod.task.data.Task

@Dao
interface TaskDAO {

    @Insert
    suspend fun saveTask(task: Task): Long

    @Query(value = "SELECT * FROM TASK ORDER BY createDate")
    fun getTask() : List<Task>

    @Delete
    abstract fun removeTask(task: Task)
}