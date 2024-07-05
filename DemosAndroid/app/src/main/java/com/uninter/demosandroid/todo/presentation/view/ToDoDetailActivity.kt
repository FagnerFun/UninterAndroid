package com.uninter.demosandroid.todo.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.uninter.demosandroid.R
import com.uninter.demosandroid.todo.domain.entity.ToDo
import com.uninter.demosandroid.todo.presentation.viewmodel.ToDoDetailViewModel
import com.uninter.demosandroid.todo.presentation.viewmodel.ToDoViewModelFactory

class ToDoDetailActivity : AppCompatActivity() {

    private lateinit var edtTitle: EditText
    private lateinit var btnComplete: Button
    private lateinit var btnRemove: Button
    private lateinit var btnAdd: Button

    private val viewModel by lazy {
        var factory = ToDoViewModelFactory(application)
        ViewModelProvider(this, factory)[ToDoDetailViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_detail)

        var todo = intent.getSerializableExtra("todo") as ToDo?

        bindView()
        ShowUI(todo)

        btnAdd.setOnClickListener(){
            onClickAdd()
        }

        btnRemove.setOnClickListener(){
            onClickRemove()
        }

        btnComplete.setOnClickListener(){
            onClickCompleted(todo)
        }
    }

    private fun onClickCompleted(todo: ToDo?) {
        todo?.let { item ->
            viewModel.completeToDo(item)
            Toast.makeText(this, "Tarefa completa", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun onClickRemove() {
        viewModel.removeToDo(edtTitle.text.toString())
        Toast.makeText(this, "Tarefa removida", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun onClickAdd() {
        viewModel.addToDo(edtTitle.text.toString())
        Toast.makeText(this, "Tarefa adicionada", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun bindView()
    {
        edtTitle = findViewById(R.id.edtTitle)
        btnComplete = findViewById(R.id.btnComplete)
        btnRemove = findViewById(R.id.btnRemove)
        btnAdd = findViewById(R.id.btnAdd)
    }

    private fun ShowUI(todo: ToDo?)
    {
        if(todo == null)
        {
            btnComplete.visibility = View.GONE
            btnRemove.visibility = View.GONE
            btnAdd.visibility = View.VISIBLE
        }
        else
        {
            btnComplete.visibility = if(todo.isCompleted) View.GONE else View.VISIBLE
            btnRemove.visibility = View.VISIBLE
            btnAdd.visibility = View.GONE

            edtTitle.setText(todo.title)
            edtTitle.isEnabled = false
        }
    }
}