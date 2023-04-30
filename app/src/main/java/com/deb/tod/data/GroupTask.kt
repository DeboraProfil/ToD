package com.deb.tod.data

data class GroupTask(
    val name : String,
    val tasks : List<Task>

)
data class Task(
    val name : String,
    val isCompleted : Boolean = false,
    val createdDate: Long = System.currentTimeMillis()
)