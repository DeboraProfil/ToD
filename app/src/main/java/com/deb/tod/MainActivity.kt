package com.deb.tod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.deb.tod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var activityMainbinding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainbinding?.root)

        activityMainbinding?.newTaskButton?.setOnClickListener {
            Toast.makeText(this, "Teste botão de tarefas", Toast.LENGTH_SHORT).show()
             NewTaskBottomSheet{

             }
            .show(supportFragmentManager, "NewTaskBottomSheet")

        }


    }
}