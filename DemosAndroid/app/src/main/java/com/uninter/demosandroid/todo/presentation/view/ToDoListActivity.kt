package com.uninter.demosandroid.todo.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninter.demosandroid.R
import com.uninter.demosandroid.todo.data.repository.ToDoMemoryRepository

class ToDoListActivity : AppCompatActivity() {

//    var rcToDoList : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        var rcToDoList = findViewById<RecyclerView>(R.id.rcToDo)
        rcToDoList.layoutManager = LinearLayoutManager(this)
        rcToDoList.adapter = ToDoListAdapter(ToDoMemoryRepository.getAll())
    }
}