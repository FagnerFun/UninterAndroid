package com.uninter.demosandroid.todo.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninter.demosandroid.R
import com.uninter.demosandroid.databinding.ActivityToDoListBinding
import com.uninter.demosandroid.todo.data.repository.ToDoMemoryRepository
import com.uninter.demosandroid.todo.presentation.viewmodel.ToDoViewModel

class ToDoListActivity : AppCompatActivity() {

    lateinit var binding: ActivityToDoListBinding
    val viewModel by lazy {
        ViewModelProvider(this).get(ToDoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToDoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.todos.observe(this)
        {
            binding.rcToDo.layoutManager = LinearLayoutManager(this)
            binding.rcToDo.adapter = ToDoListAdapter(it)
        }


        binding.btnAddTask.setOnClickListener{
            viewModel.addToDo()
        }
    }
}