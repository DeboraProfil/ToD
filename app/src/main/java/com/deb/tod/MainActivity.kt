package com.deb.tod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deb.tod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var mainActivitybinding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivitybinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivitybinding?.root)
        mainActivitybinding?.btnCreateGroup
    }
}