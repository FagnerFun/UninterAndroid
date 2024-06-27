package com.uninter.demosandroid.todo.data.repository

import com.uninter.demosandroid.todo.domain.abstractions.IToDoRepository
import com.uninter.demosandroid.todo.domain.entity.ToDo

object ToDoMemoryRepository: IToDoRepository {

    private var list = listOf(
        ToDo("Banana", false),
        ToDo("Laranja", true),
        ToDo("Pera", true)
    )

    override fun add(todo: ToDo): List<ToDo>
    {
        list = list.plus(todo)
        return list
    }

    override fun getAll(): List<ToDo> = list


    override fun delete(title: String)
    {
        list = list.filter { it -> it.title != title }
    }
}