package com.example.desert.modernandroidapp

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.desert.modernandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var repository = Repository("Android repos app", "Q", 697, true)

    object Constants {
        const val DELAY: Long = 2000;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.repository = repository;
        binding.executePendingBindings()

        Handler().postDelayed({
            repository.repositoryName = "New Name"
            binding.repository = repository;
            binding.executePendingBindings()
        }, Constants.DELAY)
    }
}
