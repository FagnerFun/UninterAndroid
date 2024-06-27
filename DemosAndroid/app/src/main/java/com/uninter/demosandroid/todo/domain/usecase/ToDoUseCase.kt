package com.uninter.demosandroid.todo.domain.usecase

import com.uninter.demosandroid.todo.data.repository.ToDoMemoryRepository
import com.uninter.demosandroid.todo.domain.abstractions.IToDoRepository
import com.uninter.demosandroid.todo.domain.entity.ToDo
import com.uninter.demosandroid.todo.domain.usecase.interfaces.IToDoUseCase

class ToDoUseCase : IToDoUseCase {

    val repository : IToDoRepository = ToDoMemoryRepository

    override fun add(toDo: ToDo): List<ToDo> {
        repository.add(toDo);

        return repository.getAll()
    }

    override fun getAll(): List<ToDo> {
        return repository.getAll()
    }

    override fun delete(title: String) {
        repository.getAll()
    }
}