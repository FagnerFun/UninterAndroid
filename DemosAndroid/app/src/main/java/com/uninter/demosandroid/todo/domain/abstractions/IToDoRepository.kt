package com.uninter.demosandroid.todo.domain.abstractions

import com.uninter.demosandroid.todo.domain.entity.ToDo

interface IToDoRepository {
    fun add(toDo : ToDo): List<ToDo>
    fun getAll(): List<ToDo>
    fun delete(title: String)
}