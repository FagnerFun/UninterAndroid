package com.uninter.demosandroid.todo.data.repository

import android.app.Application
import androidx.room.Room
import com.uninter.demosandroid.todo.data.repository.room.ToDoDataBase
import com.uninter.demosandroid.todo.domain.abstractions.IToDoRepository
import com.uninter.demosandroid.todo.domain.entity.ToDo

class ToDoSQLiteRepository(application: Application): IToDoRepository {

    companion object{
        var database: ToDoDataBase? = null
    }

    init {
        database = Room.databaseBuilder(application, ToDoDataBase::class.java,"my-db")
                       .allowMainThreadQueries()
                       .build()
    }

    override fun add(toDo: ToDo) {
        database?.toDoDao()?.insert(toDo)
    }

    override fun getAll(): List<ToDo> {
        return database?.toDoDao()?.getAll()!!
    }

    override fun delete(title: String) {
        var todo = database?.toDoDao()?.get(title)?.first()
        todo?.let{
            database?.toDoDao()?.delete(it)
        }
    }

    override fun completeToDo(toDo: ToDo) {
        toDo.isCompleted = true;
        database?.toDoDao()?.update(toDo)
    }
}