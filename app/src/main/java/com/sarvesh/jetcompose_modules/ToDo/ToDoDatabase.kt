package com.sarvesh.jetcompose_modules.ToDo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sarvesh.jetcompose_modules.ToDo.dao.TodoDao
import com.sarvesh.jetcompose_modules.ToDo.dto.ToDoDTO

@Database(
    entities = [ToDoDTO::class],
    version = 1,
    exportSchema = false
)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun getTodoDao() : TodoDao
}