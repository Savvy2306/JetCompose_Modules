package com.sarvesh.jetcompose_modules.ToDo

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarvesh.jetcompose_modules.ToDo.dto.ToDoDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewmodel
@Inject
constructor(private val todoRepository: TodoRepository) : ViewModel() {

    val response: MutableState<List<ToDoDTO>> = mutableStateOf(listOf())

    init {
        getAllTodo()
    }

    fun insertTodo(toDoDTO: ToDoDTO) = viewModelScope.launch {
        todoRepository.insertTodo(toDoDTO)
    }

    fun getAllTodo() = viewModelScope.launch {
        todoRepository.getAllTodo()
            .catch { e ->
                Log.d("main", "Exception : ${e.message}")
            }.collect {
                response.value = it
            }
    }

}