package com.uninter.demosandroid.todo.data.repository.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uninter.demosandroid.todo.domain.entity.ToDo

@Dao
interface IToDoDao {

    @Query("SELECT * FROM todo")
    fun getAll(): List<ToDo>
    @Query("SELECT * FROM todo Where title = :title")
    fun get(title: String): List<ToDo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg toDo: ToDo)

    @Update
    fun update(toDo: ToDo)

    @Delete
    fun delete(toDo: ToDo)
}