package com.deb.tod.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.deb.tod.R
import com.deb.tod.databinding.TaskLayoutBinding

class TaskAdapter(val tasks: List<String>,val onRemove: (String) -> Unit): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false)
        return TaskViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind()
    }

    inner class TaskViewHolder(itemView: View) : ViewHolder(itemView){

        fun bind() {
            val binding = TaskLayoutBinding.bind(itemView)
            val task = tasks[adapterPosition]
            binding.textTask.text = task
            binding.removeTask.setOnClickListener {
                onRemove(task)
            }
        }
    }

}