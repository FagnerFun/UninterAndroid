package com.uninter.demosandroid.todo.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.uninter.demosandroid.todo.domain.entity.ToDo
import com.uninter.demosandroid.todo.domain.usecase.ToDoUseCase
import com.uninter.demosandroid.todo.domain.usecase.interfaces.IToDoUseCase

class ToDoDetailViewModel(application: Application): ViewModel() {
    private val useCase: IToDoUseCase = ToDoUseCase(application)

    fun addToDo(title: String)
    {
        var toDo = ToDo(title,false)
        useCase.add(toDo)
    }
    fun removeToDo(title: String)
    {
        useCase.delete(title)
    }
    fun completeToDo(toDo: ToDo)
    {
        useCase.completeToDo(toDo)
    }
}