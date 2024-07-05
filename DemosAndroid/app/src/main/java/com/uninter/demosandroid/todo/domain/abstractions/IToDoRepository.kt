package com.uninter.demosandroid.todo.domain.abstractions

import com.uninter.demosandroid.todo.domain.entity.ToDo

interface IToDoRepository {
    fun add(toDo : ToDo)
    fun getAll(): List<ToDo>
    fun delete(title: String)
    fun completeToDo(toDo: ToDo)
}