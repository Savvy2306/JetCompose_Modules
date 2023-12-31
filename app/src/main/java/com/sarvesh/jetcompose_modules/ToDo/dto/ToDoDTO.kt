package com.sarvesh.jetcompose_modules.ToDo.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoTable")
data class ToDoDTO(
    val title: String,
    val description:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}
