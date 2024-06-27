package com.uninter.demosandroid.todo.data.repository

import com.uninter.demosandroid.todo.domain.entity.ToDo

object ToDoMemoryRepository {

    private var list = listOf(
        ToDo("Banana", false, "#FF0000"),
        ToDo("Laranja", true, "#00FF00"),
        ToDo("Pera", true, "#0000FF")
    )

    fun add(todo: ToDo)
    {
        list = list.plus(todo)
    }

    fun getAll(): List<ToDo>
    {
        return list
    }

    fun delete(title: String)
    {
        list = list.filter { it -> it.title != title }
    }
}