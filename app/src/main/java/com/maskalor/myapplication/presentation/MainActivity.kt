package com.maskalor.myapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.maskalor.myapplication.R
import com.maskalor.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var vm: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[MainViewModel::class.java]

        vm.taskLists.observe(this){
            binding.tabLayout.removeAllTabs()
            for (taskList in it) {
                binding.tabLayout.addTab(binding.tabLayout.newTab().setText(taskList.name))
            }
        }

        binding.addTaskListButton.setOnClickListener {
            vm.addTaskList("TEST: ${Random.nextInt()}")
        }

        vm.getAllTAskList()

    }
}