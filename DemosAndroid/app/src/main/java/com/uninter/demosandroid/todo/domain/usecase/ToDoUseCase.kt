package com.uninter.demosandroid.todo.domain.usecase

import android.app.Application
import com.uninter.demosandroid.todo.data.repository.ToDoMemoryRepository
import com.uninter.demosandroid.todo.data.repository.ToDoSQLiteRepository
import com.uninter.demosandroid.todo.domain.abstractions.IToDoRepository
import com.uninter.demosandroid.todo.domain.entity.ToDo
import com.uninter.demosandroid.todo.domain.usecase.interfaces.IToDoUseCase

class ToDoUseCase(application: Application) : IToDoUseCase {

    private val repository : IToDoRepository = ToDoSQLiteRepository(application)

    override fun add(toDo: ToDo){
        repository.add(toDo);
    }

    override fun getAll(): List<ToDo> {
        return repository.getAll()
    }

    override fun delete(title: String) {
        repository.delete(title)
    }

    override fun completeToDo(toDo: ToDo)
    {
        repository.completeToDo(toDo)
    }
}