package com.sarvesh.jetcompose_modules.ToDo

import com.sarvesh.jetcompose_modules.ToDo.dao.TodoDao
import com.sarvesh.jetcompose_modules.ToDo.dto.ToDoDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TodoRepository
@Inject
constructor(private val todoDao: TodoDao) {

    suspend fun insertTodo(toDoDTO: ToDoDTO) = withContext(Dispatchers.IO){
        todoDao.insertTodo(toDoDTO)
    }

    fun getAllTodo(): Flow<List<ToDoDTO>> = todoDao.getAllTodos()

}