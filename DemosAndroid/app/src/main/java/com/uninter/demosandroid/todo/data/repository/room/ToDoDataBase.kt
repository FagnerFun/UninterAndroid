package com.uninter.demosandroid.todo.data.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uninter.demosandroid.todo.domain.entity.ToDo

@Database(version = 1, entities = [ToDo::class])
abstract class ToDoDataBase: RoomDatabase() {
    abstract fun toDoDao(): IToDoDao
}