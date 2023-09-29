package com.sarvesh.jetcompose_modules.ToDo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.sarvesh.jetcompose_modules.ToDo.dto.ToDoDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertTodo(toDoDTO: ToDoDTO)

    @Query("SELECT * FROM todoTable")
    fun getAllTodos():Flow<List<ToDoDTO>>
}