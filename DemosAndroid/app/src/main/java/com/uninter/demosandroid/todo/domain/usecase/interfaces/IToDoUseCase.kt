package com.uninter.demosandroid.todo.domain.usecase.interfaces

import com.uninter.demosandroid.todo.domain.entity.ToDo

interface IToDoUseCase {
    fun add(toDo: ToDo)
    fun getAll(): List<ToDo>
    fun delete(title: String)
    fun completeToDo(toDo: ToDo)
}