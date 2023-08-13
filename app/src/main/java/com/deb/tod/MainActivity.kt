package com.deb.tod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deb.tod.adapter.TaskAdapter
import com.deb.tod.databinding.ActivityMainBinding
import com.deb.tod.task.data.Task

class MainActivity : AppCompatActivity() {

    private var activityMainbinding: ActivityMainBinding? = null
    private val mainActivityViewModel: MainActivityViewModel  by lazy { MainActivityViewModel(this.application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainbinding?.root)
        observeViewModel()
        activityMainbinding?.newTaskButton?.setOnClickListener {
            NewTaskBottomSheet {
                mainActivityViewModel.saveTask(it)
            }.show(supportFragmentManager, "NewTaskBottomSheet")

        }




        activityMainbinding?.recyclerViewTasks?.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            mainActivityViewModel.listTask()

    }

    private fun updateTaskList(newTasks: List<Task>) {
        activityMainbinding?.recyclerViewTasks?.adapter = TaskAdapter(newTasks) { task ->
            mainActivityViewModel.removeTask(task)
        }
    }

    private fun observeViewModel (){
        mainActivityViewModel.state.observe(this) {
            when(it) {
                is MainActivityViewModel.MainActivityState.TaskListState -> updateTaskList(it.tasks)

            }
        }
    }
}
