package com.uninter.demosandroid.todo.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "todo")
data class ToDo(@PrimaryKey val title:String,
           @ColumnInfo(name = "is_completed") var isCompleted:Boolean):Serializable {
}