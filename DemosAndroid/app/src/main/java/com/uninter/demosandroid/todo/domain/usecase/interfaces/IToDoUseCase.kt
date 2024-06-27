package com.uninter.demosandroid.todo.domain.usecase.interfaces

import com.uninter.demosandroid.todo.domain.entity.ToDo

interface IToDoUseCase {
    fun add(toDo: ToDo): List<ToDo>
    fun getAll(): List<ToDo>
    fun delete(title: String)
}