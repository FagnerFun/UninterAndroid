package com.uninter.demosandroid.todo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uninter.demosandroid.todo.domain.entity.ToDo
import com.uninter.demosandroid.todo.domain.usecase.ToDoUseCase
import com.uninter.demosandroid.todo.domain.usecase.interfaces.IToDoUseCase

class ToDoViewModel: ViewModel() {
    private val useCase: IToDoUseCase = ToDoUseCase()
    var todos = MutableLiveData<List<ToDo>>()

    init {
        Thread(Runnable {
            loadToDo()
        }).start()
    }

    fun loadToDo()
    {
        todos.postValue(useCase.getAll())
    }

    fun addToDo()
    {
        var toDo = ToDo("novo item",false)
        todos.postValue(useCase.add(toDo))
    }
}