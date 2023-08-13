package com.deb.tod

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.deb.tod.task.data.Task
import com.deb.tod.task.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    sealed class MainActivityState {
        data class TaskListState(val tasks: List<Task>) : MainActivityState()
    }

    private val taskRepository = TaskRepository(application.applicationContext)
    val state = MutableLiveData<MainActivityState>()


    fun saveTask(taskDescription: String) {
        val task =
            Task(name = taskDescription, createDate = Calendar.getInstance().timeInMillis)
        viewModelScope.launch(Dispatchers.IO) {

            val newTask = taskRepository.saveTask(task)
            Log.i(javaClass.simpleName, "saveTask: new task -> $newTask")
            listTask()
        }

    }

    fun listTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val tasks = taskRepository.getTask()
            Log.d(javaClass.simpleName, "listTask: Lista de tarefas -> $tasks ")
            state.postValue(MainActivityState.TaskListState(tasks))
        }
    }

    fun removeTask(task: Task) {
        viewModelScope.launch (Dispatchers.IO){
            taskRepository.removeTask(task)
            listTask()
        }
    }
}