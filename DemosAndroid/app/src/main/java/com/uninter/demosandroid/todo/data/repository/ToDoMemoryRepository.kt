package com.uninter.demosandroid.todo.data.repository

import com.uninter.demosandroid.todo.domain.abstractions.IToDoRepository
import com.uninter.demosandroid.todo.domain.entity.ToDo

object ToDoMemoryRepository: IToDoRepository {

    private var list = listOf(
        ToDo("Banana", false),
        ToDo("Laranja", true),
        ToDo("Pera", true)
    )

    override fun add(todo: ToDo)
    {
        list = list.plus(todo)
    }

    override fun getAll(): List<ToDo> = list


    override fun delete(title: String)
    {
        list = list.filter { it -> it.title != title }
    }

    override fun completeToDo(toDo: ToDo) {
        for(item in list)
        {
            if(item.title == toDo.title)
                item.isCompleted = true
        }
    }
}