package com.deb.tod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deb.tod.adapter.TaskAdapter
import com.deb.tod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var activityMainbinding: ActivityMainBinding? = null
    private var tasks = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainbinding?.root)

        activityMainbinding?.newTaskButton?.setOnClickListener {
            Toast.makeText(this, "Teste botão de tarefas", Toast.LENGTH_SHORT).show()
            NewTaskBottomSheet {
                Toast.makeText(this, "tarefa adicionada - > $it", Toast.LENGTH_SHORT).show()
                tasks.add(it)
                updateTaskList(tasks)


            }.show(supportFragmentManager, "NewTaskBottomSheet")

        }

        activityMainbinding?.recyclerViewTasks?.adapter = TaskAdapter(tasks){
            tasks.remove(it)
            updateTaskList(tasks)

        }


        activityMainbinding?.recyclerViewTasks?.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)


    }

    private fun  updateTaskList(newTasks: ArrayList <String>){
        tasks = newTasks
        activityMainbinding?.recyclerViewTasks?.adapter = TaskAdapter(tasks) { task ->
            tasks.remove(task)
            updateTaskList(tasks)
        }
    }
}